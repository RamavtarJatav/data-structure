package org.enum1.com;

public enum BindingMode {
	U, 
    UQ,
    S,
    SQ,
    US;
	
	static BindingMode getBindingMode(String mode) {
		return BindingMode.valueOf(mode);
	}
    
}
