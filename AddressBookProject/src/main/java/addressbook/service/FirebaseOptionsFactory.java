package addressbook.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseOptions;

public class FirebaseOptionsFactory {

	@NotBlank
	@JsonProperty
	private String databaseUrl;

	@NotBlank
	@JsonProperty
	private String credentialPath;

	public String getDatabaseUrl() {
		return databaseUrl;
	}

	public void setDatabaseUrl(String databaseUrl) {
		this.databaseUrl = databaseUrl;
	}

	public String getCredentialPath() {
		return credentialPath;
	}

	public void setCredentialPath(String credentialPath) {
		this.credentialPath = credentialPath;
	}

	public FirebaseOptions build() throws IOException {
		FileInputStream serviceAccount = new FileInputStream(credentialPath);
		return new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.setDatabaseUrl(databaseUrl)
				.build();
	}
}