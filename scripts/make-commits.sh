#!/usr/bin/env bash
# Create sample commits step by step (Git Bash OK).
# After each step: push -> scan the new commit -> verify README -> next step.
#   ./scripts/make-commits.sh baseline   # commit 1: full sample
#   ./scripts/make-commits.sh i1         # commit 2: change ONLY value of URL_API_CHKUSERINFO
#   ./scripts/make-commits.sh i2         # commit 3: change ONLY one caller argument
#   ./scripts/make-commits.sh i3         # commit 4: change ONLY chain leaf literal (3 hops)
set -euo pipefail
cd "$(dirname "$0")/.."
CONST=src/main/java/com/util/ExpApiUriConstant.java
LEAF=src/main/java/com/util/ExpApiUriChainLeafConstant.java
V2=src/main/java/com/user/service/V2QualifiedConstantUserService.java
case "${1:-}" in
  baseline)
    [ -d .git ] || git init -b master
    git add -A
    git commit -m "test(const-url): baseline sample for outbound constant URL variants" ;;
  i1)
    sed -i 's#{@do-01.api-selectUserList-001}"#{@do-01.api-selectUserList-002}"#' "$CONST"
    git add "$CONST"; git commit -m "test(const-url): I1 change URL_API_CHKUSERINFO value only" ;;
  i2)
    sed -i '0,/return restTemplate.get(ExpApiUriConstant.URL_API_USERINFO,/s//return restTemplate.get(ExpApiUriConstant.URL_API_USERINFO_FQN,/' "$V2"
    git add "$V2"; git commit -m "test(const-url): I2 switch retrieveListUserInfo to URL_API_USERINFO_FQN" ;;
  i3)
    sed -i 's#{@do-01.api-selectUserChain-001}"#{@do-01.api-selectUserChain-002}"#' "$LEAF"
    git add "$LEAF"; git commit -m "test(const-url): I3 change chain leaf literal only" ;;
  *) echo "Usage: $0 baseline|i1|i2|i3"; exit 1 ;;
esac
git log --oneline -1
