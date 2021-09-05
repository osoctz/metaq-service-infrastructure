package cn.metaq.uaa.constant;

public enum GroupType {

    ROLE(1),USER(0),RESOURCE(2);

    private Integer value;
    GroupType(int value) {
        this.value=value;
    }

    public Integer value(){
        return this.value;
    }

}
