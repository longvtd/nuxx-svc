package com.lguplus.nuxx.service;
import com.lguplus.nuxx.repository.BundleBaseRepository;
import com.lguplus.nuxx.entity.BundleBaseEntity;
import com.lguplus.nuxx.common.BundleBizException;
import com.lguplus.nuxx.common.BundleNullUtil;
import com.lguplus.nuxx.common.BundleUuidUtil;
import com.lguplus.nuxx.dto.BundleBaseEntityDTO;
import com.lguplus.nuxx.dto.BundleMessageDTO;
import com.lguplus.wafful.event.BundleMessagePublisher;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class BundleBaseBasTestService {
    private final BundleApiService bundleApiService;
    private final BundleBaseRepository bundleBaseRepository;
    private final BundleMessagePublisher bundleMessagePublisher;
    public BundleBaseBasTestService(BundleApiService api, BundleBaseRepository repository, BundleMessagePublisher publisher) {
        bundleApiService=api; bundleBaseRepository=repository; bundleMessagePublisher=publisher;
    }
    public String oldMethod() { return "baseline"; }

    public void saveBundleBaseM(BundleBaseEntityDTO dto) {
        if (BundleNullUtil.isNull(dto)) {
            throw new BundleBizException("Bundle base is empty");
        }
        if (BundleNullUtil.isNone(dto.getBundleBaseId())) {
            dto.setBundleBaseId(BundleUuidUtil.genAlphaNumericRandomUUID(32));
        }
        String entryInfo = bundleApiService.retrieveBundleInfo(dto.getBundleBaseId());
        String description = bundleApiService.retrieveBundleCode(entryInfo, dto.getBundleBaseCode());
        BundleBaseEntity entity = BundleBaseEntity.builder()
                .bundleBaseId(dto.getBundleBaseId())
                .bundleBaseCode(dto.getBundleBaseCode())
                .bundleBaseName(dto.getBundleBaseName())
                .bundleBaseDescription(description)
                .bundleBaseDivision(dto.getBundleBaseDivision())
                .validStart(dto.getValidStart())
                .validEnd(dto.getValidEnd())
                .build();
        bundleBaseRepository.save(entity);

        List<BundleMessageDTO> itemList = new ArrayList<>();
        BundleMessageDTO item = new BundleMessageDTO();
        item.setBundleCode(entity.toString());
        itemList.add(item);
        List<BundleMessageDTO> messageList = new ArrayList<>();
        BundleMessageDTO message = new BundleMessageDTO();
        message.setBundleInfoList(itemList);
        messageList.add(message);
        BundleMessageDTO envelope = new BundleMessageDTO();
        envelope.setBundleInfoList(messageList);
        String partitionId = dto.getBundleBaseId();
        bundleMessagePublisher.publishBundle(envelope, partitionId); // publisher to_nuxx_bundle_event
    }
}
