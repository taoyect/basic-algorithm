// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: newProto/contactsNew.proto
// Protobuf Java Version: 4.29.3

package com.example.newProto;

public interface PeopleInfoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:newProto.PeopleInfo)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string name = 1;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>string name = 1;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>int32 age = 2;</code>
   * @return The age.
   */
  int getAge();

  /**
   * <pre>
   * 需要带上phone.proto的package
   * </pre>
   *
   * <code>repeated .start.Phone phone = 3;</code>
   */
  java.util.List<com.example.start.Phone> 
      getPhoneList();
  /**
   * <pre>
   * 需要带上phone.proto的package
   * </pre>
   *
   * <code>repeated .start.Phone phone = 3;</code>
   */
  com.example.start.Phone getPhone(int index);
  /**
   * <pre>
   * 需要带上phone.proto的package
   * </pre>
   *
   * <code>repeated .start.Phone phone = 3;</code>
   */
  int getPhoneCount();
  /**
   * <pre>
   * 需要带上phone.proto的package
   * </pre>
   *
   * <code>repeated .start.Phone phone = 3;</code>
   */
  java.util.List<? extends com.example.start.PhoneOrBuilder> 
      getPhoneOrBuilderList();
  /**
   * <pre>
   * 需要带上phone.proto的package
   * </pre>
   *
   * <code>repeated .start.Phone phone = 3;</code>
   */
  com.example.start.PhoneOrBuilder getPhoneOrBuilder(
      int index);
}
