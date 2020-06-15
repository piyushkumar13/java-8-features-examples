package com.piyush.practice.enums;

import com.piyush.practice.domain.model.Student;

/**
 * @author Piyush Kumar.
 * @since 2020-06-15.
 */
public enum Singleton implements IExample { /* We can implement interfaces but we cannot extend a class. */
  INSTANCE{
    @Override
    public String getValue() {
      return this.value;
    }

    @Override
    public void setValue(String value) {
      this.value = value; // If we use private modifier with value, this line will give error.
    }
  };

  protected String value;

  /* By default contructor of enum is private.*/
  Singleton() {
  }
//  Uncomment below if you want to set value while creating object using constructor and use this INSTANCE("some"){...}
//  Singleton(String passValue) {
//      this.value = passValue;
//  }

  public abstract void setValue(String value);

  public static void main(String[] args) {
    Singleton enumObj = Singleton.INSTANCE;
    enumObj.setValue("something");
    System.out.println(enumObj.getValue());
  }
}
