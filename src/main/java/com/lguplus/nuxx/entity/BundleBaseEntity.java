package com.lguplus.nuxx.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
@Entity
@Table(name = "TB_BUNDLE_BASE_M")
@Builder
public class BundleBaseEntity {
    private final String bundleBaseId;
    private final String bundleBaseCode;
    private final String bundleBaseName;
    private final String bundleBaseDescription;
    private final String bundleBaseDivision;
    private final String validStart;
    private final String validEnd;
    private BundleBaseEntity(BuilderState b) {
        bundleBaseId=b.id; bundleBaseCode=b.code; bundleBaseName=b.name; bundleBaseDescription=b.description;
        bundleBaseDivision=b.division; validStart=b.start; validEnd=b.end;
    }
    public static BuilderState builder() { return new BuilderState(); }
    public static final class BuilderState {
        private String id,code,name,description,division,start,end;
        public BuilderState bundleBaseId(String v) { id=v; return this; }
        public BuilderState bundleBaseCode(String v) { code=v; return this; }
        public BuilderState bundleBaseName(String v) { name=v; return this; }
        public BuilderState bundleBaseDescription(String v) { description=v; return this; }
        public BuilderState bundleBaseDivision(String v) { division=v; return this; }
        public BuilderState validStart(String v) { start=v; return this; }
        public BuilderState validEnd(String v) { end=v; return this; }
        public BundleBaseEntity build() { return new BundleBaseEntity(this); }
    }
}
