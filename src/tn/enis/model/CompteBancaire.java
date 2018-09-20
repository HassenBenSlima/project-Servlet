package tn.enis.model;

import java.io.Serializable;

public class CompteBancaire implements Serializable {
	private static final long serialVersionUID = 1L;

	private long rib;
	private String client;
	private float solde;

	public CompteBancaire() {
		super();
	}

	public CompteBancaire(String client, float solde) {
		super();
		this.client = client;
		this.solde = solde;
	}

	public long getRib() {
		return rib;
	}

	public void setRib(long rib) {
		this.rib = rib;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (rib ^ (rib >>> 32));
		return result;
	}

	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		
		CompteBancaire other = (CompteBancaire) obj;
		if (rib != other.rib) {
			return false;
		}
		return true;
	}

}
