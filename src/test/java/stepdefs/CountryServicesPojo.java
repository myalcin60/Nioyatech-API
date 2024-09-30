package stepdefs;

public class CountryServicesPojo {
	private String currency_name;
	private String currency_symbol;
	private String name;
	private String currency;
	private String iso2;

	public CountryServicesPojo(String currency_name, String currency_symbol, String name, String currency, String iso2) {
		this.currency_name = currency_name;
		this.currency_symbol = currency_symbol;
		this.name = name;
		this.currency = currency;
		this.iso2 = iso2;
	}

	public CountryServicesPojo() {
	}

	public void setCurrency_name(String currency_name){
		this.currency_name = currency_name;
	}

	public String getCurrency_name(){
		return currency_name;
	}

	public void setCurrency_symbol(String currency_symbol){
		this.currency_symbol = currency_symbol;
	}

	public String getCurrency_symbol(){
		return currency_symbol;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setCurrency(String currency){
		this.currency = currency;
	}

	public String getCurrency(){
		return currency;
	}

	public void setIso2(String iso2){
		this.iso2 = iso2;
	}

	public String getIso2(){
		return iso2;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"currency_name = '" + currency_name + '\'' +
			",currency_symbol = '" + currency_symbol + '\'' +
			",name = '" + name + '\'' + 
			",currency = '" + currency + '\'' + 
			",iso2 = '" + iso2 + '\'' + 
			"}";
		}
}
