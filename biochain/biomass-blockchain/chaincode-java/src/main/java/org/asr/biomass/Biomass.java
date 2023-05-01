/*
 * SPDX-License-Identifier: Apache-2.0
 */

package org.asr.biomass;

import java.util.Objects;

import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;

import com.owlike.genson.annotation.JsonProperty;

@DataType()
public final class Biomass {
	/**
	 * Woody Fuels. Wood wastes of all types make excellent biomass fuels and can be used in a wide variety of biomass technologies. ...
	   Forestry Residues. ...
	   Mill Residues. ...
	   Agricultural Residues. ...
	   Urban Wood and Yard Wastes. ...
	   Dedicated Biomass Crops. ...
	   Chemical Recovery Fuels. ...
	   Animal Wastes
	 */

    @Property()
    private final String biomassID;

    @Property()
    private final String name;

    @Property()
    private final int weight;

    @Property()
    private final String owner;

    @Property()
    private final int appraisedValue;

    public String getBiomassID() {
        return biomassID;
    }

    public String getName() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    public String getOwner() {
        return owner;
    }

    public int getAppraisedValue() {
        return appraisedValue;
    }

    public Biomass(@JsonProperty("biomassID") final String biomassID, @JsonProperty("color") final String color,
            @JsonProperty("weight") final int weight, @JsonProperty("owner") final String owner,
            @JsonProperty("appraisedValue") final int appraisedValue) {
        this.biomassID = biomassID;
        this.color = color;
        this.weight = weight;
        this.owner = owner;
        this.appraisedValue = appraisedValue;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }

        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }

        Biomass other = (Biomass) obj;

        return Objects.deepEquals(
                new String[] {getBiomassID(), getColor(), getOwner()},
                new String[] {other.getBiomassID(), other.getColor(), other.getOwner()})
                &&
                Objects.deepEquals(
                new int[] {getWeight(), getAppraisedValue()},
                new int[] {other.getWeight(), other.getAppraisedValue()});
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBiomassID(), getColor(), getWeight(), getOwner(), getAppraisedValue());
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " [biomassID=" + biomassID + ", color="
                + color + ", weight=" + weight + ", owner=" + owner + ", appraisedValue=" + appraisedValue + "]";
    }
}
