package com.example.demo.dal.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * entry
 * @author 
 */
public class Entry implements Serializable {
    private Long id;

    private Long loadId;

    private Integer bucketId;

    private Integer value;

    private Date effectiveTime;

    private Date creatTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLoadId() {
        return loadId;
    }

    public void setLoadId(Long loadId) {
        this.loadId = loadId;
    }

    public Integer getBucketId() {
        return bucketId;
    }

    public void setBucketId(Integer bucketId) {
        this.bucketId = bucketId;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Date getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Entry other = (Entry) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLoadId() == null ? other.getLoadId() == null : this.getLoadId().equals(other.getLoadId()))
            && (this.getBucketId() == null ? other.getBucketId() == null : this.getBucketId().equals(other.getBucketId()))
            && (this.getValue() == null ? other.getValue() == null : this.getValue().equals(other.getValue()))
            && (this.getEffectiveTime() == null ? other.getEffectiveTime() == null : this.getEffectiveTime().equals(other.getEffectiveTime()))
            && (this.getCreatTime() == null ? other.getCreatTime() == null : this.getCreatTime().equals(other.getCreatTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLoadId() == null) ? 0 : getLoadId().hashCode());
        result = prime * result + ((getBucketId() == null) ? 0 : getBucketId().hashCode());
        result = prime * result + ((getValue() == null) ? 0 : getValue().hashCode());
        result = prime * result + ((getEffectiveTime() == null) ? 0 : getEffectiveTime().hashCode());
        result = prime * result + ((getCreatTime() == null) ? 0 : getCreatTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", loadId=").append(loadId);
        sb.append(", bucketId=").append(bucketId);
        sb.append(", value=").append(value);
        sb.append(", effectiveTime=").append(effectiveTime);
        sb.append(", creatTime=").append(creatTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}