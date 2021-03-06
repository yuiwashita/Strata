/**
 * Copyright (C) 2016 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.product.option;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.joda.beans.Bean;
import org.joda.beans.BeanBuilder;
import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

/**
 * Continuous barrier with constant barrier level.
 * <p>
 * This defines a simple continuous barrier with a constant barrier level.
 * It is assumed that the barrier event period agrees with the lifetime of the option,
 * thus observation start date and end date are not specified in this class.
 */
@BeanDefinition(builderScope = "private")
public final class SimpleConstantContinuousBarrier
    implements Barrier, ImmutableBean, Serializable {

  /**
   * The barrier type.
   */
  @PropertyDefinition(validate = "notNull", overrideGet = true)
  private final BarrierType barrierType;
  /**
   * The knock type.
   */
  @PropertyDefinition(validate = "notNull", overrideGet = true)
  private final KnockType knockType;
  /**
   * The barrier level.
   */
  @PropertyDefinition
  private final double barrierLevel;

  //-------------------------------------------------------------------------
  /**
   * Obtains the continuous barrier with constant barrier level.
   * 
   * @param barrierType  the barrier type
   * @param knockType  the knock type
   * @param barrierLevel  the barrier level
   * @return the instance
   */
  public static SimpleConstantContinuousBarrier of(BarrierType barrierType, KnockType knockType, double barrierLevel) {
    return new SimpleConstantContinuousBarrier(barrierType, knockType, barrierLevel);
  }

  //-------------------------------------------------------------------------
  @Override
  public double getBarrierLevel(LocalDate date) {
    return barrierLevel;
  }

  @Override
  public SimpleConstantContinuousBarrier inverseKnockType() {
    KnockType inverse = knockType.equals(KnockType.KNOCK_IN) ? KnockType.KNOCK_OUT : KnockType.KNOCK_IN;
    return of(barrierType, inverse, barrierLevel);
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code SimpleConstantContinuousBarrier}.
   * @return the meta-bean, not null
   */
  public static SimpleConstantContinuousBarrier.Meta meta() {
    return SimpleConstantContinuousBarrier.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(SimpleConstantContinuousBarrier.Meta.INSTANCE);
  }

  /**
   * The serialization version id.
   */
  private static final long serialVersionUID = 1L;

  private SimpleConstantContinuousBarrier(
      BarrierType barrierType,
      KnockType knockType,
      double barrierLevel) {
    JodaBeanUtils.notNull(barrierType, "barrierType");
    JodaBeanUtils.notNull(knockType, "knockType");
    this.barrierType = barrierType;
    this.knockType = knockType;
    this.barrierLevel = barrierLevel;
  }

  @Override
  public SimpleConstantContinuousBarrier.Meta metaBean() {
    return SimpleConstantContinuousBarrier.Meta.INSTANCE;
  }

  @Override
  public <R> Property<R> property(String propertyName) {
    return metaBean().<R>metaProperty(propertyName).createProperty(this);
  }

  @Override
  public Set<String> propertyNames() {
    return metaBean().metaPropertyMap().keySet();
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the barrier type.
   * @return the value of the property, not null
   */
  @Override
  public BarrierType getBarrierType() {
    return barrierType;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the knock type.
   * @return the value of the property, not null
   */
  @Override
  public KnockType getKnockType() {
    return knockType;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the barrier level.
   * @return the value of the property
   */
  public double getBarrierLevel() {
    return barrierLevel;
  }

  //-----------------------------------------------------------------------
  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      SimpleConstantContinuousBarrier other = (SimpleConstantContinuousBarrier) obj;
      return JodaBeanUtils.equal(barrierType, other.barrierType) &&
          JodaBeanUtils.equal(knockType, other.knockType) &&
          JodaBeanUtils.equal(barrierLevel, other.barrierLevel);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash = hash * 31 + JodaBeanUtils.hashCode(barrierType);
    hash = hash * 31 + JodaBeanUtils.hashCode(knockType);
    hash = hash * 31 + JodaBeanUtils.hashCode(barrierLevel);
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(128);
    buf.append("SimpleConstantContinuousBarrier{");
    buf.append("barrierType").append('=').append(barrierType).append(',').append(' ');
    buf.append("knockType").append('=').append(knockType).append(',').append(' ');
    buf.append("barrierLevel").append('=').append(JodaBeanUtils.toString(barrierLevel));
    buf.append('}');
    return buf.toString();
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code SimpleConstantContinuousBarrier}.
   */
  public static final class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code barrierType} property.
     */
    private final MetaProperty<BarrierType> barrierType = DirectMetaProperty.ofImmutable(
        this, "barrierType", SimpleConstantContinuousBarrier.class, BarrierType.class);
    /**
     * The meta-property for the {@code knockType} property.
     */
    private final MetaProperty<KnockType> knockType = DirectMetaProperty.ofImmutable(
        this, "knockType", SimpleConstantContinuousBarrier.class, KnockType.class);
    /**
     * The meta-property for the {@code barrierLevel} property.
     */
    private final MetaProperty<Double> barrierLevel = DirectMetaProperty.ofImmutable(
        this, "barrierLevel", SimpleConstantContinuousBarrier.class, Double.TYPE);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "barrierType",
        "knockType",
        "barrierLevel");

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case 1029043089:  // barrierType
          return barrierType;
        case 975895086:  // knockType
          return knockType;
        case 1827586573:  // barrierLevel
          return barrierLevel;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public BeanBuilder<? extends SimpleConstantContinuousBarrier> builder() {
      return new SimpleConstantContinuousBarrier.Builder();
    }

    @Override
    public Class<? extends SimpleConstantContinuousBarrier> beanType() {
      return SimpleConstantContinuousBarrier.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code barrierType} property.
     * @return the meta-property, not null
     */
    public MetaProperty<BarrierType> barrierType() {
      return barrierType;
    }

    /**
     * The meta-property for the {@code knockType} property.
     * @return the meta-property, not null
     */
    public MetaProperty<KnockType> knockType() {
      return knockType;
    }

    /**
     * The meta-property for the {@code barrierLevel} property.
     * @return the meta-property, not null
     */
    public MetaProperty<Double> barrierLevel() {
      return barrierLevel;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case 1029043089:  // barrierType
          return ((SimpleConstantContinuousBarrier) bean).getBarrierType();
        case 975895086:  // knockType
          return ((SimpleConstantContinuousBarrier) bean).getKnockType();
        case 1827586573:  // barrierLevel
          return ((SimpleConstantContinuousBarrier) bean).getBarrierLevel();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      metaProperty(propertyName);
      if (quiet) {
        return;
      }
      throw new UnsupportedOperationException("Property cannot be written: " + propertyName);
    }

  }

  //-----------------------------------------------------------------------
  /**
   * The bean-builder for {@code SimpleConstantContinuousBarrier}.
   */
  private static final class Builder extends DirectFieldsBeanBuilder<SimpleConstantContinuousBarrier> {

    private BarrierType barrierType;
    private KnockType knockType;
    private double barrierLevel;

    /**
     * Restricted constructor.
     */
    private Builder() {
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case 1029043089:  // barrierType
          return barrierType;
        case 975895086:  // knockType
          return knockType;
        case 1827586573:  // barrierLevel
          return barrierLevel;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case 1029043089:  // barrierType
          this.barrierType = (BarrierType) newValue;
          break;
        case 975895086:  // knockType
          this.knockType = (KnockType) newValue;
          break;
        case 1827586573:  // barrierLevel
          this.barrierLevel = (Double) newValue;
          break;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
      return this;
    }

    @Override
    public Builder set(MetaProperty<?> property, Object value) {
      super.set(property, value);
      return this;
    }

    @Override
    public Builder setString(String propertyName, String value) {
      setString(meta().metaProperty(propertyName), value);
      return this;
    }

    @Override
    public Builder setString(MetaProperty<?> property, String value) {
      super.setString(property, value);
      return this;
    }

    @Override
    public Builder setAll(Map<String, ? extends Object> propertyValueMap) {
      super.setAll(propertyValueMap);
      return this;
    }

    @Override
    public SimpleConstantContinuousBarrier build() {
      return new SimpleConstantContinuousBarrier(
          barrierType,
          knockType,
          barrierLevel);
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(128);
      buf.append("SimpleConstantContinuousBarrier.Builder{");
      buf.append("barrierType").append('=').append(JodaBeanUtils.toString(barrierType)).append(',').append(' ');
      buf.append("knockType").append('=').append(JodaBeanUtils.toString(knockType)).append(',').append(' ');
      buf.append("barrierLevel").append('=').append(JodaBeanUtils.toString(barrierLevel));
      buf.append('}');
      return buf.toString();
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
