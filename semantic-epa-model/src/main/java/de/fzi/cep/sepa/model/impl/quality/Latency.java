package de.fzi.cep.sepa.model.impl.quality;

import javax.persistence.Entity;

import com.clarkparsia.empire.annotation.Namespaces;
import com.clarkparsia.empire.annotation.RdfProperty;
import com.clarkparsia.empire.annotation.RdfsClass;

@Namespaces({"sepa", "http://sepa.event-processing.org/sepa#",
	 "ssn",   "http://purl.oclc.org/NET/ssnx/ssn#"})
@RdfsClass("ssn:Latency")
@Entity
public class Latency extends EventPropertyQuality {
	public Latency() {
		super();
	}
	
	public Latency(float quantityValue) {
		this.quantityValue = quantityValue;
	}
	
	@RdfProperty("sepa:hasQuantityValue")
	float quantityValue;

	public float getQuantityValue() {
		return quantityValue;
	}

	public void setQuantityValue(float quantityValue) {
		this.quantityValue = quantityValue;
	}
	
	
}
