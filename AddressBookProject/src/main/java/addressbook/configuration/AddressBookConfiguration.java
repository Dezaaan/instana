package addressbook.configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import addressbook.service.FirebaseOptionsFactory;
import io.dropwizard.Configuration;

public class AddressBookConfiguration extends Configuration {

	@Valid
	@NotNull
	@JsonProperty("firebase")
	private FirebaseOptionsFactory firebaseOptions;

	public FirebaseOptionsFactory getFirebaseOptionsFactory() {
		return firebaseOptions;
	}

	public void setFirebaseOptions(FirebaseOptionsFactory firebaseOptions) {
		this.firebaseOptions = firebaseOptions;
	}
}
