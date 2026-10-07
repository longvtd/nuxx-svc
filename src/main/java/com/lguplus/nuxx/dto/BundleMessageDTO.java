package com.lguplus.nuxx.dto;
import java.util.ArrayList;
import java.util.List;
public class BundleMessageDTO {
    private String bundleCode;
    private List<BundleMessageDTO> bundleInfoList;
    public void setBundleCode(String value) { bundleCode=value; }
    public void setBundleInfoList(List<BundleMessageDTO> value) { bundleInfoList=value; }
    public String getBundleCode() { return bundleCode; }
    public List<BundleMessageDTO> getBundleInfoList() { return bundleInfoList; }
    public static List<BundleMessageDTO> newList() { return new ArrayList<>(); }
}
