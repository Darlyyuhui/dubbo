package com.darly.dubbo.security.user;


/**
 * <p>菜单类型</p>
 * @author zhouhaij
 * @since 1.0
 * @version
 */
public enum MenuType {

	MODULE(0),
	
	BUTTON(1);
	
	private final int value;
	
	private MenuType(int type){
		this.value = type;
	}
	

    public int value() {
        return this.value;
    }

    public String toString() {
        return Integer.toString(this.value);
    }

    public static MenuType valueOf(int levelValue) {
        for (MenuType type : values()) {
            if (type.value == levelValue) {
                return type;
            }
        }
        throw new IllegalArgumentException("No matching constant for [" + levelValue + "]");
    }
	
	
}
