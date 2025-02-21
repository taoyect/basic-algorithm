// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: newProto/contactsNew.proto
// Protobuf Java Version: 4.29.3

package com.example.newProto;

/**
 * Protobuf type {@code newProto.PeopleInfo}
 */
public final class PeopleInfo extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:newProto.PeopleInfo)
    PeopleInfoOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 29,
      /* patch= */ 3,
      /* suffix= */ "",
      PeopleInfo.class.getName());
  }
  // Use PeopleInfo.newBuilder() to construct.
  private PeopleInfo(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private PeopleInfo() {
    name_ = "";
    phone_ = java.util.Collections.emptyList();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.example.newProto.ContactProtos.internal_static_newProto_PeopleInfo_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.example.newProto.ContactProtos.internal_static_newProto_PeopleInfo_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.example.newProto.PeopleInfo.class, com.example.newProto.PeopleInfo.Builder.class);
  }

  public static final int NAME_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object name_ = "";
  /**
   * <code>string name = 1;</code>
   * @return The name.
   */
  @java.lang.Override
  public java.lang.String getName() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      name_ = s;
      return s;
    }
  }
  /**
   * <code>string name = 1;</code>
   * @return The bytes for name.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getNameBytes() {
    java.lang.Object ref = name_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      name_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int AGE_FIELD_NUMBER = 2;
  private int age_ = 0;
  /**
   * <code>int32 age = 2;</code>
   * @return The age.
   */
  @java.lang.Override
  public int getAge() {
    return age_;
  }

  public static final int PHONE_FIELD_NUMBER = 3;
  @SuppressWarnings("serial")
  private java.util.List<com.example.start.Phone> phone_;
  /**
   * <pre>
   * 需要带上phone.proto的package
   * </pre>
   *
   * <code>repeated .start.Phone phone = 3;</code>
   */
  @java.lang.Override
  public java.util.List<com.example.start.Phone> getPhoneList() {
    return phone_;
  }
  /**
   * <pre>
   * 需要带上phone.proto的package
   * </pre>
   *
   * <code>repeated .start.Phone phone = 3;</code>
   */
  @java.lang.Override
  public java.util.List<? extends com.example.start.PhoneOrBuilder> 
      getPhoneOrBuilderList() {
    return phone_;
  }
  /**
   * <pre>
   * 需要带上phone.proto的package
   * </pre>
   *
   * <code>repeated .start.Phone phone = 3;</code>
   */
  @java.lang.Override
  public int getPhoneCount() {
    return phone_.size();
  }
  /**
   * <pre>
   * 需要带上phone.proto的package
   * </pre>
   *
   * <code>repeated .start.Phone phone = 3;</code>
   */
  @java.lang.Override
  public com.example.start.Phone getPhone(int index) {
    return phone_.get(index);
  }
  /**
   * <pre>
   * 需要带上phone.proto的package
   * </pre>
   *
   * <code>repeated .start.Phone phone = 3;</code>
   */
  @java.lang.Override
  public com.example.start.PhoneOrBuilder getPhoneOrBuilder(
      int index) {
    return phone_.get(index);
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
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(name_)) {
      com.google.protobuf.GeneratedMessage.writeString(output, 1, name_);
    }
    if (age_ != 0) {
      output.writeInt32(2, age_);
    }
    for (int i = 0; i < phone_.size(); i++) {
      output.writeMessage(3, phone_.get(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessage.isStringEmpty(name_)) {
      size += com.google.protobuf.GeneratedMessage.computeStringSize(1, name_);
    }
    if (age_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, age_);
    }
    for (int i = 0; i < phone_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, phone_.get(i));
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
    if (!(obj instanceof com.example.newProto.PeopleInfo)) {
      return super.equals(obj);
    }
    com.example.newProto.PeopleInfo other = (com.example.newProto.PeopleInfo) obj;

    if (!getName()
        .equals(other.getName())) return false;
    if (getAge()
        != other.getAge()) return false;
    if (!getPhoneList()
        .equals(other.getPhoneList())) return false;
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
    hash = (37 * hash) + NAME_FIELD_NUMBER;
    hash = (53 * hash) + getName().hashCode();
    hash = (37 * hash) + AGE_FIELD_NUMBER;
    hash = (53 * hash) + getAge();
    if (getPhoneCount() > 0) {
      hash = (37 * hash) + PHONE_FIELD_NUMBER;
      hash = (53 * hash) + getPhoneList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.example.newProto.PeopleInfo parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.newProto.PeopleInfo parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.newProto.PeopleInfo parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.newProto.PeopleInfo parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.newProto.PeopleInfo parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.newProto.PeopleInfo parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.newProto.PeopleInfo parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static com.example.newProto.PeopleInfo parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static com.example.newProto.PeopleInfo parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static com.example.newProto.PeopleInfo parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.newProto.PeopleInfo parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static com.example.newProto.PeopleInfo parseFrom(
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
  public static Builder newBuilder(com.example.newProto.PeopleInfo prototype) {
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
   * Protobuf type {@code newProto.PeopleInfo}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:newProto.PeopleInfo)
      com.example.newProto.PeopleInfoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.example.newProto.ContactProtos.internal_static_newProto_PeopleInfo_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.example.newProto.ContactProtos.internal_static_newProto_PeopleInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.example.newProto.PeopleInfo.class, com.example.newProto.PeopleInfo.Builder.class);
    }

    // Construct using com.example.newProto.PeopleInfo.newBuilder()
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
      name_ = "";
      age_ = 0;
      if (phoneBuilder_ == null) {
        phone_ = java.util.Collections.emptyList();
      } else {
        phone_ = null;
        phoneBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000004);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.example.newProto.ContactProtos.internal_static_newProto_PeopleInfo_descriptor;
    }

    @java.lang.Override
    public com.example.newProto.PeopleInfo getDefaultInstanceForType() {
      return com.example.newProto.PeopleInfo.getDefaultInstance();
    }

    @java.lang.Override
    public com.example.newProto.PeopleInfo build() {
      com.example.newProto.PeopleInfo result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.example.newProto.PeopleInfo buildPartial() {
      com.example.newProto.PeopleInfo result = new com.example.newProto.PeopleInfo(this);
      buildPartialRepeatedFields(result);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartialRepeatedFields(com.example.newProto.PeopleInfo result) {
      if (phoneBuilder_ == null) {
        if (((bitField0_ & 0x00000004) != 0)) {
          phone_ = java.util.Collections.unmodifiableList(phone_);
          bitField0_ = (bitField0_ & ~0x00000004);
        }
        result.phone_ = phone_;
      } else {
        result.phone_ = phoneBuilder_.build();
      }
    }

    private void buildPartial0(com.example.newProto.PeopleInfo result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.name_ = name_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.age_ = age_;
      }
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.example.newProto.PeopleInfo) {
        return mergeFrom((com.example.newProto.PeopleInfo)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.example.newProto.PeopleInfo other) {
      if (other == com.example.newProto.PeopleInfo.getDefaultInstance()) return this;
      if (!other.getName().isEmpty()) {
        name_ = other.name_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (other.getAge() != 0) {
        setAge(other.getAge());
      }
      if (phoneBuilder_ == null) {
        if (!other.phone_.isEmpty()) {
          if (phone_.isEmpty()) {
            phone_ = other.phone_;
            bitField0_ = (bitField0_ & ~0x00000004);
          } else {
            ensurePhoneIsMutable();
            phone_.addAll(other.phone_);
          }
          onChanged();
        }
      } else {
        if (!other.phone_.isEmpty()) {
          if (phoneBuilder_.isEmpty()) {
            phoneBuilder_.dispose();
            phoneBuilder_ = null;
            phone_ = other.phone_;
            bitField0_ = (bitField0_ & ~0x00000004);
            phoneBuilder_ = 
              com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders ?
                 getPhoneFieldBuilder() : null;
          } else {
            phoneBuilder_.addAllMessages(other.phone_);
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
              name_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 16: {
              age_ = input.readInt32();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
            case 26: {
              com.example.start.Phone m =
                  input.readMessage(
                      com.example.start.Phone.parser(),
                      extensionRegistry);
              if (phoneBuilder_ == null) {
                ensurePhoneIsMutable();
                phone_.add(m);
              } else {
                phoneBuilder_.addMessage(m);
              }
              break;
            } // case 26
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

    private java.lang.Object name_ = "";
    /**
     * <code>string name = 1;</code>
     * @return The name.
     */
    public java.lang.String getName() {
      java.lang.Object ref = name_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        name_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string name = 1;</code>
     * @return The bytes for name.
     */
    public com.google.protobuf.ByteString
        getNameBytes() {
      java.lang.Object ref = name_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        name_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string name = 1;</code>
     * @param value The name to set.
     * @return This builder for chaining.
     */
    public Builder setName(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      name_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>string name = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearName() {
      name_ = getDefaultInstance().getName();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>string name = 1;</code>
     * @param value The bytes for name to set.
     * @return This builder for chaining.
     */
    public Builder setNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      name_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private int age_ ;
    /**
     * <code>int32 age = 2;</code>
     * @return The age.
     */
    @java.lang.Override
    public int getAge() {
      return age_;
    }
    /**
     * <code>int32 age = 2;</code>
     * @param value The age to set.
     * @return This builder for chaining.
     */
    public Builder setAge(int value) {

      age_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>int32 age = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearAge() {
      bitField0_ = (bitField0_ & ~0x00000002);
      age_ = 0;
      onChanged();
      return this;
    }

    private java.util.List<com.example.start.Phone> phone_ =
      java.util.Collections.emptyList();
    private void ensurePhoneIsMutable() {
      if (!((bitField0_ & 0x00000004) != 0)) {
        phone_ = new java.util.ArrayList<com.example.start.Phone>(phone_);
        bitField0_ |= 0x00000004;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilder<
        com.example.start.Phone, com.example.start.Phone.Builder, com.example.start.PhoneOrBuilder> phoneBuilder_;

    /**
     * <pre>
     * 需要带上phone.proto的package
     * </pre>
     *
     * <code>repeated .start.Phone phone = 3;</code>
     */
    public java.util.List<com.example.start.Phone> getPhoneList() {
      if (phoneBuilder_ == null) {
        return java.util.Collections.unmodifiableList(phone_);
      } else {
        return phoneBuilder_.getMessageList();
      }
    }
    /**
     * <pre>
     * 需要带上phone.proto的package
     * </pre>
     *
     * <code>repeated .start.Phone phone = 3;</code>
     */
    public int getPhoneCount() {
      if (phoneBuilder_ == null) {
        return phone_.size();
      } else {
        return phoneBuilder_.getCount();
      }
    }
    /**
     * <pre>
     * 需要带上phone.proto的package
     * </pre>
     *
     * <code>repeated .start.Phone phone = 3;</code>
     */
    public com.example.start.Phone getPhone(int index) {
      if (phoneBuilder_ == null) {
        return phone_.get(index);
      } else {
        return phoneBuilder_.getMessage(index);
      }
    }
    /**
     * <pre>
     * 需要带上phone.proto的package
     * </pre>
     *
     * <code>repeated .start.Phone phone = 3;</code>
     */
    public Builder setPhone(
        int index, com.example.start.Phone value) {
      if (phoneBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePhoneIsMutable();
        phone_.set(index, value);
        onChanged();
      } else {
        phoneBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     * 需要带上phone.proto的package
     * </pre>
     *
     * <code>repeated .start.Phone phone = 3;</code>
     */
    public Builder setPhone(
        int index, com.example.start.Phone.Builder builderForValue) {
      if (phoneBuilder_ == null) {
        ensurePhoneIsMutable();
        phone_.set(index, builderForValue.build());
        onChanged();
      } else {
        phoneBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * 需要带上phone.proto的package
     * </pre>
     *
     * <code>repeated .start.Phone phone = 3;</code>
     */
    public Builder addPhone(com.example.start.Phone value) {
      if (phoneBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePhoneIsMutable();
        phone_.add(value);
        onChanged();
      } else {
        phoneBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <pre>
     * 需要带上phone.proto的package
     * </pre>
     *
     * <code>repeated .start.Phone phone = 3;</code>
     */
    public Builder addPhone(
        int index, com.example.start.Phone value) {
      if (phoneBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePhoneIsMutable();
        phone_.add(index, value);
        onChanged();
      } else {
        phoneBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     * 需要带上phone.proto的package
     * </pre>
     *
     * <code>repeated .start.Phone phone = 3;</code>
     */
    public Builder addPhone(
        com.example.start.Phone.Builder builderForValue) {
      if (phoneBuilder_ == null) {
        ensurePhoneIsMutable();
        phone_.add(builderForValue.build());
        onChanged();
      } else {
        phoneBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * 需要带上phone.proto的package
     * </pre>
     *
     * <code>repeated .start.Phone phone = 3;</code>
     */
    public Builder addPhone(
        int index, com.example.start.Phone.Builder builderForValue) {
      if (phoneBuilder_ == null) {
        ensurePhoneIsMutable();
        phone_.add(index, builderForValue.build());
        onChanged();
      } else {
        phoneBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * 需要带上phone.proto的package
     * </pre>
     *
     * <code>repeated .start.Phone phone = 3;</code>
     */
    public Builder addAllPhone(
        java.lang.Iterable<? extends com.example.start.Phone> values) {
      if (phoneBuilder_ == null) {
        ensurePhoneIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, phone_);
        onChanged();
      } else {
        phoneBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <pre>
     * 需要带上phone.proto的package
     * </pre>
     *
     * <code>repeated .start.Phone phone = 3;</code>
     */
    public Builder clearPhone() {
      if (phoneBuilder_ == null) {
        phone_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000004);
        onChanged();
      } else {
        phoneBuilder_.clear();
      }
      return this;
    }
    /**
     * <pre>
     * 需要带上phone.proto的package
     * </pre>
     *
     * <code>repeated .start.Phone phone = 3;</code>
     */
    public Builder removePhone(int index) {
      if (phoneBuilder_ == null) {
        ensurePhoneIsMutable();
        phone_.remove(index);
        onChanged();
      } else {
        phoneBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <pre>
     * 需要带上phone.proto的package
     * </pre>
     *
     * <code>repeated .start.Phone phone = 3;</code>
     */
    public com.example.start.Phone.Builder getPhoneBuilder(
        int index) {
      return getPhoneFieldBuilder().getBuilder(index);
    }
    /**
     * <pre>
     * 需要带上phone.proto的package
     * </pre>
     *
     * <code>repeated .start.Phone phone = 3;</code>
     */
    public com.example.start.PhoneOrBuilder getPhoneOrBuilder(
        int index) {
      if (phoneBuilder_ == null) {
        return phone_.get(index);  } else {
        return phoneBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <pre>
     * 需要带上phone.proto的package
     * </pre>
     *
     * <code>repeated .start.Phone phone = 3;</code>
     */
    public java.util.List<? extends com.example.start.PhoneOrBuilder> 
         getPhoneOrBuilderList() {
      if (phoneBuilder_ != null) {
        return phoneBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(phone_);
      }
    }
    /**
     * <pre>
     * 需要带上phone.proto的package
     * </pre>
     *
     * <code>repeated .start.Phone phone = 3;</code>
     */
    public com.example.start.Phone.Builder addPhoneBuilder() {
      return getPhoneFieldBuilder().addBuilder(
          com.example.start.Phone.getDefaultInstance());
    }
    /**
     * <pre>
     * 需要带上phone.proto的package
     * </pre>
     *
     * <code>repeated .start.Phone phone = 3;</code>
     */
    public com.example.start.Phone.Builder addPhoneBuilder(
        int index) {
      return getPhoneFieldBuilder().addBuilder(
          index, com.example.start.Phone.getDefaultInstance());
    }
    /**
     * <pre>
     * 需要带上phone.proto的package
     * </pre>
     *
     * <code>repeated .start.Phone phone = 3;</code>
     */
    public java.util.List<com.example.start.Phone.Builder> 
         getPhoneBuilderList() {
      return getPhoneFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilder<
        com.example.start.Phone, com.example.start.Phone.Builder, com.example.start.PhoneOrBuilder> 
        getPhoneFieldBuilder() {
      if (phoneBuilder_ == null) {
        phoneBuilder_ = new com.google.protobuf.RepeatedFieldBuilder<
            com.example.start.Phone, com.example.start.Phone.Builder, com.example.start.PhoneOrBuilder>(
                phone_,
                ((bitField0_ & 0x00000004) != 0),
                getParentForChildren(),
                isClean());
        phone_ = null;
      }
      return phoneBuilder_;
    }

    // @@protoc_insertion_point(builder_scope:newProto.PeopleInfo)
  }

  // @@protoc_insertion_point(class_scope:newProto.PeopleInfo)
  private static final com.example.newProto.PeopleInfo DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.example.newProto.PeopleInfo();
  }

  public static com.example.newProto.PeopleInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PeopleInfo>
      PARSER = new com.google.protobuf.AbstractParser<PeopleInfo>() {
    @java.lang.Override
    public PeopleInfo parsePartialFrom(
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

  public static com.google.protobuf.Parser<PeopleInfo> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PeopleInfo> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.example.newProto.PeopleInfo getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

