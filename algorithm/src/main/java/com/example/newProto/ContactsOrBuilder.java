// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: newProto/contactsNew.proto
// Protobuf Java Version: 4.29.3

package com.example.newProto;

public interface ContactsOrBuilder extends
    // @@protoc_insertion_point(interface_extends:newProto.Contacts)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .newProto.PeopleInfo contacts = 1;</code>
   */
  java.util.List<com.example.newProto.PeopleInfo> 
      getContactsList();
  /**
   * <code>repeated .newProto.PeopleInfo contacts = 1;</code>
   */
  com.example.newProto.PeopleInfo getContacts(int index);
  /**
   * <code>repeated .newProto.PeopleInfo contacts = 1;</code>
   */
  int getContactsCount();
  /**
   * <code>repeated .newProto.PeopleInfo contacts = 1;</code>
   */
  java.util.List<? extends com.example.newProto.PeopleInfoOrBuilder> 
      getContactsOrBuilderList();
  /**
   * <code>repeated .newProto.PeopleInfo contacts = 1;</code>
   */
  com.example.newProto.PeopleInfoOrBuilder getContactsOrBuilder(
      int index);
}
