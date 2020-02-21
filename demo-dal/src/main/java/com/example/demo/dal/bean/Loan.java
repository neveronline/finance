package com.example.demo.dal.bean;

import java.io.Serializable;

/**
 * loan
 * @author 
 */
public class Loan implements Serializable {
    private Integer id;

    private Integer amount;

    private Integer interest;

    private Integer duration;

    /**
     * 1 for yearly, 2 for monthly
     */
    private Byte interestType;

    /**
     * 1 for year, 2 for month
     */
    private Byte durationType;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getInterest() {
        return interest;
    }

    public void setInterest(Integer interest) {
        this.interest = interest;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Byte getInterestType() {
        return interestType;
    }

    public void setInterestType(Byte interestType) {
        this.interestType = interestType;
    }

    public Byte getDurationType() {
        return durationType;
    }

    public void setDurationType(Byte durationType) {
        this.durationType = durationType;
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
        Loan other = (Loan) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getInterest() == null ? other.getInterest() == null : this.getInterest().equals(other.getInterest()))
            && (this.getDuration() == null ? other.getDuration() == null : this.getDuration().equals(other.getDuration()))
            && (this.getInterestType() == null ? other.getInterestType() == null : this.getInterestType().equals(other.getInterestType()))
            && (this.getDurationType() == null ? other.getDurationType() == null : this.getDurationType().equals(other.getDurationType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getInterest() == null) ? 0 : getInterest().hashCode());
        result = prime * result + ((getDuration() == null) ? 0 : getDuration().hashCode());
        result = prime * result + ((getInterestType() == null) ? 0 : getInterestType().hashCode());
        result = prime * result + ((getDurationType() == null) ? 0 : getDurationType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", amount=").append(amount);
        sb.append(", interest=").append(interest);
        sb.append(", duration=").append(duration);
        sb.append(", interestType=").append(interestType);
        sb.append(", durationType=").append(durationType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}