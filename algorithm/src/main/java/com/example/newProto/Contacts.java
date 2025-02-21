// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: newProto/contactsNew.proto
// Protobuf Java Version: 4.29.3

package com.example.newProto;

/**
 * Protobuf type {@code newProto.Contacts}
 */
public final class Contacts extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:newProto.Contacts)
    ContactsOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 29,
      /* patch= */ 3,
      /* suffix= */ "",
      Contacts.class.getName());
  }
  // Use Contacts.newBuilder() to construct.
  private Contacts(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private Contacts() {
    contacts_ = java.util.Collections.emptyList();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.example.newProto.ContactProtos.internal_static_newProto_Contacts_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.example.newProto.ContactProtos.internal_static_newProto_Contacts_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.example.newProto.Contacts.class, com.example.newProto.Contacts.Builder.class);
  }

  public static final int CONTACTS_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private java.util.List<com.example.newProto.PeopleInfo> contacts_;
  /**
   * <code>repeated .newProto.PeopleInfo contacts = 1;</code>
   */
  @java.lang.Override
  public java.util.List<com.example.newProto.PeopleInfo> getContactsList() {
    return contacts_;
  }
  /**
   * <code>repeated .newProto.PeopleInfo contacts = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends com.example.newProto.PeopleInfoOrBuilder> 
      getContactsOrBuilderList() {
    return contacts_;
  }
  /**
   * <code>repeated .newProto.PeopleInfo contacts = 1;</code>
   */
  @java.lang.Override
  public int getContactsCount() {
    return contacts_.size();
  }
  /**
   * <code>repeated .newProto.PeopleInfo contacts = 1;</code>
   */
  @java.lang.Override
  public com.example.newProto.PeopleInfo getContacts(int index) {
    return contacts_.get(index);
  }
  /**
   * <code>repeated .newProto.PeopleInfo contacts = 1;</code>
   */
  @java.lang.Override
  public com.example.newProto.PeopleInfoOrBuilder getContactsOrBuilder(
      int index) {
    return contacts_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < contacts_.size(); i++) {
      output.writeMessage(1, contacts_.get(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < contacts_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, contacts_.get(i));
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.example.newProto.Contacts)) {
      return super.equals(obj);
    }
    com.example.newProto.Contacts other = (com.example.newProto.Contacts) obj;

    if (!getContactsList()
        .equals(other.getContactsList())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getContactsCount() > 0) {
      hash = (37 * hash) + CONTACTS_FIELD_NUMBER;
      hash = (53 * hash) + getContactsList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.example.newProto.Contacts parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.newProto.Contacts parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.newProto.Contacts parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.newProto.Contacts parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.newProto.Contacts parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.newProto.Contacts parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.newProto.Contacts parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static com.example.newProto.Contacts parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static com.example.newProto.Contacts parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static com.example.newProto.Contacts parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.newProto.Contacts parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static com.example.newProto.Contacts parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.example.newProto.Contacts prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessage.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code newProto.Contacts}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:newProto.Contacts)
      com.example.newProto.ContactsOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.example.newProto.ContactProtos.internal_static_newProto_Contacts_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.example.newProto.ContactProtos.internal_static_newProto_Contacts_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.example.newProto.Contacts.class, com.example.newProto.Contacts.Builder.class);
    }

    // Construct using com.example.newProto.Contacts.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      if (contactsBuilder_ == null) {
        contacts_ = java.util.Collections.emptyList();
      } else {
        contacts_ = null;
        contactsBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.example.newProto.ContactProtos.internal_static_newProto_Contacts_descriptor;
    }

    @java.lang.Override
    public com.example.newProto.Contacts getDefaultInstanceForType() {
      return com.example.newProto.Contacts.getDefaultInstance();
    }

    @java.lang.Override
    public com.example.newProto.Contacts build() {
      com.example.newProto.Contacts result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.example.newProto.Contacts buildPartial() {
      com.example.newProto.Contacts result = new com.example.newProto.Contacts(this);
      buildPartialRepeatedFields(result);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartialRepeatedFields(com.example.newProto.Contacts result) {
      if (contactsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          contacts_ = java.util.Collections.unmodifiableList(contacts_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.contacts_ = contacts_;
      } else {
        result.contacts_ = contactsBuilder_.build();
      }
    }

    private void buildPartial0(com.example.newProto.Contacts result) {
      int from_bitField0_ = bitField0_;
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.example.newProto.Contacts) {
        return mergeFrom((com.example.newProto.Contacts)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.example.newProto.Contacts other) {
      if (other == com.example.newProto.Contacts.getDefaultInstance()) return this;
      if (contactsBuilder_ == null) {
        if (!other.contacts_.isEmpty()) {
          if (contacts_.isEmpty()) {
            contacts_ = other.contacts_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureContactsIsMutable();
            contacts_.addAll(other.contacts_);
          }
          onChanged();
        }
      } else {
        if (!other.contacts_.isEmpty()) {
          if (contactsBuilder_.isEmpty()) {
            contactsBuilder_.dispose();
            contactsBuilder_ = null;
            contacts_ = other.contacts_;
            bitField0_ = (bitField0_ & ~0x00000001);
            contactsBuilder_ = 
              com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders ?
                 getContactsFieldBuilder() : null;
          } else {
            contactsBuilder_.addAllMessages(other.contacts_);
          }
        }
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              com.example.newProto.PeopleInfo m =
                  input.readMessage(
                      com.example.newProto.PeopleInfo.parser(),
                      extensionRegistry);
              if (contactsBuilder_ == null) {
                ensureContactsIsMutable();
                contacts_.add(m);
              } else {
                contactsBuilder_.addMessage(m);
              }
              break;
            } // case 10
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private java.util.List<com.example.newProto.PeopleInfo> contacts_ =
      java.util.Collections.emptyList();
    private void ensureContactsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        contacts_ = new java.util.ArrayList<com.example.newProto.PeopleInfo>(contacts_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilder<
        com.example.newProto.PeopleInfo, com.example.newProto.PeopleInfo.Builder, com.example.newProto.PeopleInfoOrBuilder> contactsBuilder_;

    /**
     * <code>repeated .newProto.PeopleInfo contacts = 1;</code>
     */
    public java.util.List<com.example.newProto.PeopleInfo> getContactsList() {
      if (contactsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(contacts_);
      } else {
        return contactsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .newProto.PeopleInfo contacts = 1;</code>
     */
    public int getContactsCount() {
      if (contactsBuilder_ == null) {
        return contacts_.size();
      } else {
        return contactsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .newProto.PeopleInfo contacts = 1;</code>
     */
    public com.example.newProto.PeopleInfo getContacts(int index) {
      if (contactsBuilder_ == null) {
        return contacts_.get(index);
      } else {
        return contactsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .newProto.PeopleInfo contacts = 1;</code>
     */
    public Builder setContacts(
        int index, com.example.newProto.PeopleInfo value) {
      if (contactsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureContactsIsMutable();
        contacts_.set(index, value);
        onChanged();
      } else {
        contactsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .newProto.PeopleInfo contacts = 1;</code>
     */
    public Builder setContacts(
        int index, com.example.newProto.PeopleInfo.Builder builderForValue) {
      if (contactsBuilder_ == null) {
        ensureContactsIsMutable();
        contacts_.set(index, builderForValue.build());
        onChanged();
      } else {
        contactsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .newProto.PeopleInfo contacts = 1;</code>
     */
    public Builder addContacts(com.example.newProto.PeopleInfo value) {
      if (contactsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureContactsIsMutable();
        contacts_.add(value);
        onChanged();
      } else {
        contactsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .newProto.PeopleInfo contacts = 1;</code>
     */
    public Builder addContacts(
        int index, com.example.newProto.PeopleInfo value) {
      if (contactsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureContactsIsMutable();
        contacts_.add(index, value);
        onChanged();
      } else {
        contactsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .newProto.PeopleInfo contacts = 1;</code>
     */
    public Builder addContacts(
        com.example.newProto.PeopleInfo.Builder builderForValue) {
      if (contactsBuilder_ == null) {
        ensureContactsIsMutable();
        contacts_.add(builderForValue.build());
        onChanged();
      } else {
        contactsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .newProto.PeopleInfo contacts = 1;</code>
     */
    public Builder addContacts(
        int index, com.example.newProto.PeopleInfo.Builder builderForValue) {
      if (contactsBuilder_ == null) {
        ensureContactsIsMutable();
        contacts_.add(index, builderForValue.build());
        onChanged();
      } else {
        contactsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .newProto.PeopleInfo contacts = 1;</code>
     */
    public Builder addAllContacts(
        java.lang.Iterable<? extends com.example.newProto.PeopleInfo> values) {
      if (contactsBuilder_ == null) {
        ensureContactsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, contacts_);
        onChanged();
      } else {
        contactsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .newProto.PeopleInfo contacts = 1;</code>
     */
    public Builder clearContacts() {
      if (contactsBuilder_ == null) {
        contacts_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        contactsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .newProto.PeopleInfo contacts = 1;</code>
     */
    public Builder removeContacts(int index) {
      if (contactsBuilder_ == null) {
        ensureContactsIsMutable();
        contacts_.remove(index);
        onChanged();
      } else {
        contactsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .newProto.PeopleInfo contacts = 1;</code>
     */
    public com.example.newProto.PeopleInfo.Builder getContactsBuilder(
        int index) {
      return getContactsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .newProto.PeopleInfo contacts = 1;</code>
     */
    public com.example.newProto.PeopleInfoOrBuilder getContactsOrBuilder(
        int index) {
      if (contactsBuilder_ == null) {
        return contacts_.get(index);  } else {
        return contactsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .newProto.PeopleInfo contacts = 1;</code>
     */
    public java.util.List<? extends com.example.newProto.PeopleInfoOrBuilder> 
         getContactsOrBuilderList() {
      if (contactsBuilder_ != null) {
        return contactsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(contacts_);
      }
    }
    /**
     * <code>repeated .newProto.PeopleInfo contacts = 1;</code>
     */
    public com.example.newProto.PeopleInfo.Builder addContactsBuilder() {
      return getContactsFieldBuilder().addBuilder(
          com.example.newProto.PeopleInfo.getDefaultInstance());
    }
    /**
     * <code>repeated .newProto.PeopleInfo contacts = 1;</code>
     */
    public com.example.newProto.PeopleInfo.Builder addContactsBuilder(
        int index) {
      return getContactsFieldBuilder().addBuilder(
          index, com.example.newProto.PeopleInfo.getDefaultInstance());
    }
    /**
     * <code>repeated .newProto.PeopleInfo contacts = 1;</code>
     */
    public java.util.List<com.example.newProto.PeopleInfo.Builder> 
         getContactsBuilderList() {
      return getContactsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilder<
        com.example.newProto.PeopleInfo, com.example.newProto.PeopleInfo.Builder, com.example.newProto.PeopleInfoOrBuilder> 
        getContactsFieldBuilder() {
      if (contactsBuilder_ == null) {
        contactsBuilder_ = new com.google.protobuf.RepeatedFieldBuilder<
            com.example.newProto.PeopleInfo, com.example.newProto.PeopleInfo.Builder, com.example.newProto.PeopleInfoOrBuilder>(
                contacts_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        contacts_ = null;
      }
      return contactsBuilder_;
    }

    // @@protoc_insertion_point(builder_scope:newProto.Contacts)
  }

  // @@protoc_insertion_point(class_scope:newProto.Contacts)
  private static final com.example.newProto.Contacts DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.example.newProto.Contacts();
  }

  public static com.example.newProto.Contacts getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Contacts>
      PARSER = new com.google.protobuf.AbstractParser<Contacts>() {
    @java.lang.Override
    public Contacts parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<Contacts> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Contacts> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.example.newProto.Contacts getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

