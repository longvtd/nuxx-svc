#!/usr/bin/env bash
set -euo pipefail
cd "$(dirname "$0")/.."
case "${1:-}" in
 baseline) [ -d .git ] || git init -b main; git add -A; git commit -m "test(nuxx): baseline impact sample" ;;
 c1) sed -i 's/selectCustProfile(req.getId())/selectCustByApim(req.getId())/' src/main/java/com/lguplus/nuxx/service/HmOrderService.java; git add -A; git commit -m "test(code-insight): change outbound customer lookup" ;;
 c2) sed -i 's/api-selectUserChain-001/api-selectUserChain-002/' src/main/java/com/util/ChainLeaf.java; git add -A; git commit -m "test(outbound): change chained API constant only" ;;
 c3) sed -i '/retrievePhoneLegacy/,/}/d' src/main/java/com/lguplus/nuxx/service/HmOrderService.java; git add -A; git commit -m "test(snapshot): remove legacy callable" ;;
 *) echo "Usage: $0 baseline|c1|c2|c3"; exit 1;;
esac
git log --oneline -1
