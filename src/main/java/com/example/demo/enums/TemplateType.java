package com.example.demo.enums;

public enum TemplateType {
    CONTRUCT("受注時",1),
    AFTERCONTRUCT("契約後",2),
    OTHERS("その他",3);

    private String label;
    private int typeId;

    private TemplateType(String label, int typeId) {
        this.label = label;
        this.typeId = typeId;
    }

    public String getLabel() {
        return label;
    }

    public int getTypeId(){
        return typeId;
    }

    public static TemplateType of(int typeId) {
        for (TemplateType type : TemplateType.values()) {
            if (type.getTypeId() == typeId) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant with typeId: " + typeId);
    }
    
}
