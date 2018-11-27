package com.pwc.cmaas.recruiting.interview;

public enum Type {
    TYPE_ONE("1"), TYPE_TWO("2"), TYPE_TRE("3"), TYPE_FUR("4");

    private final String typeNum;

    Type(String typeNum) {
        this.typeNum = typeNum;
    }

    public String getTypeNum() {return this.typeNum; }

    public static Type getByTypeNum(final String typeNum){
        for (Type type : values()) {
            if (type.getTypeNum().equals(typeNum)){
                return type;
            }
        }
        return TYPE_ONE;
    }
}
