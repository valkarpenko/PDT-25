package com.example.tests;

public class ContactData implements Comparable<ContactData>{
	public String firstname;
	public String lastname;
	public String address;
	public String home;
	public String mobile;
	public String work;
	public String email;
	public String email2;
	public String bday;
	public String bmonth;
	public String byear;
	public String address1;
	public String address2;
	public String phone2;

	public ContactData() {
	}
	public ContactData(String firstname, String lastname, String address, String home, String mobile, String work,
			String email, String email2, String bday, String bmonth, String byear, String address1, String address2,
			String phone2) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.home = home;
		this.mobile = mobile;
		this.work = work;
		this.email = email;
		this.email2 = email2;
		this.bday = bday;
		this.bmonth = bmonth;
		this.byear = byear;
		this.address1 = address1;
		this.address2 = address2;
		this.phone2 = phone2;
	}
		
	
    @Override
	public String toString() {
		return "ContactData [email=" + email + "]";
	}
    
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactData)) return false;

        ContactData that = (ContactData) o;

        if (!email.equals(that.email)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }
	@Override
	public int compareTo(ContactData other) {
		return this.email.toLowerCase().compareTo(other.email.toLowerCase());
	}

	
	
}