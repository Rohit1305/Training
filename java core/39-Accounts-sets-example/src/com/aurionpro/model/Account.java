package com.aurionpro.model;

public class Account {
	private int accID;
	private String accName;
	private String acctype;

	public Account(int accID, String accName, String acctype) {
		super();
		this.accID = accID;
		this.accName = accName;
		this.acctype = acctype;
	}

	public int getAccID() {
		return accID;
	}

	public void setAccID(int accID) {
		this.accID = accID;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getAcctype() {
		return acctype;
	}

	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}

	@Override
	public String toString() {
		return "Account [accID=" + accID + ", accName=" + accName + ", acctype=" + acctype + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accID;
		result = prime * result + ((accName == null) ? 0 : accName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accID != other.accID)
			return false;
		if (accName == null) {
			if (other.accName != null)
				return false;
		} else if (!accName.equals(other.accName))
			return false;
		return true;
	}

}
