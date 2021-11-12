package info.seleniumcucumber.utils.dataproviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import info.seleniumcucumber.constants.DriverType;
import info.seleniumcucumber.constants.EnvironmentType;



public class ConfigFileReader {	
	private Properties properties;
	private final String propertyFilePath= "src/test/resources/configs/browserstack.properties";

	public ConfigFileReader(){
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try { properties.load(reader); }
			catch (IOException e) { e.printStackTrace(); }
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Properties file not found at path : " + propertyFilePath);
		}finally {
			try { if(reader != null) reader.close(); }
			catch (IOException ignore) {}
		}
	}
	
	public String getDriverPath(){
		String driverPath = properties.getProperty("driverPath");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("Driver Path not specified in the Configuration.properties file for the Key:driverPath");		
	}
	
	public long getImplicitlyWait() {		
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if(implicitlyWait != null) {
			try{
				return Long.parseLong(implicitlyWait);
			}catch(NumberFormatException e) {
				throw new RuntimeException("Not able to parse value : " + implicitlyWait + " in to Long");
			}
		}
		return 30;		
	}


	public String getRegisterURL() {
		String url = properties.getProperty("registerURL");
		if(url != null) return url;
		else throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:url");
	}

	public DriverType getBrowser() {
		String browserName = properties.getProperty("browser");
		if(browserName == null || browserName.equalsIgnoreCase("chrome")) return DriverType.CHROME;
		else if(browserName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
		else if(browserName.equalsIgnoreCase("edge")) return DriverType.EDGE;
		else throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
	}
	
	public EnvironmentType getEnvironment() {
		String environmentName = properties.getProperty("environment");
		if(environmentName == null || environmentName.equalsIgnoreCase("local")) return EnvironmentType.LOCAL;
		else if(environmentName.equals("remote")) return EnvironmentType.REMOTE;
		else throw new RuntimeException("Environment Type Key value in Configuration.properties is not matched : " + environmentName);
	}
	
	public Boolean getBrowserWindowSize() {
		String windowSize = properties.getProperty("windowMaximize");
		if(windowSize != null) return Boolean.valueOf(windowSize);
		return true;
	}

	public String getPhoneOTPCode() {
		String string = properties.getProperty("phoneOTPCode");
		if(string != null) return string;
		else throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:url");
	}

	public String getEmailOTPCode() {
		String string = properties.getProperty("emailOTPCode");
		if(string != null) return string;
		else throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:url");
	}

	public String getDate() {
		String string = properties.getProperty("date");
		if(string != null) return string;
		else throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:url");
	}

	public String getMonth() {
		String string = properties.getProperty("month");
		if(string != null) return string;
		else throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:url");
	}

	public String getYear() {
		String string = properties.getProperty("year");
		if(string != null) return string;
		else throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:url");
	}

	public String getGender() {
		String string = properties.getProperty("gender");
		if(string != null) return string;
		else throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:url");
	}

	public String getCountry() {
		String string = properties.getProperty("country");
		if(string != null) return string;
		else throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:url");
	}

	public String getCategory() {
		String string = properties.getProperty("category");
		if(string != null) return string;
		else throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:url");
	}

	public String getIndustry() {
		String string = properties.getProperty("industry");
		if(string != null) return string;
		else throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:url");
	}

	public String getEntityType() {
		String string = properties.getProperty("entityType");
		if(string != null) return string;
		else throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:url");
	}

	public String getSubIndustry() {
		String string = properties.getProperty("subIndustry");
		if(string != null) return string;
		else throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:url");
	}

	public String getBusinessActivity() {
		String string = properties.getProperty("businessActivity");
		if(string != null) return string;
		else throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:url");
	}

	public String getWebsite() {
		String string = properties.getProperty("website");
		if(string != null) return string;
		else throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:url");
	}

	public String getTotalSpend() {
		String string = properties.getProperty("totalSpend");
		if(string != null) return string;
		else throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:url");
	}

	public String getKindOfIdentity() {
		String string = properties.getProperty("kindOfIdentity");
		if(string != null) return string;
		else throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:url");
	}

	public String getKindOfIdentity2() {
		String string = properties.getProperty("kindOfIdentity2");
		if(string != null) return string;
		else throw new RuntimeException("Application Url not specified in the Configuration.properties file for the Key:url");
	}
	

}
