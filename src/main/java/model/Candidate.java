package model;

public class Candidate {
	private int candidateId;
	private String name;
	private String party;
	private int votes;
	 
	public Candidate(){
		 
	 }
	public Candidate(String name,String party) {
		this.name = name;
		this.party = party;
		this.votes=0;
	}
	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	public int getCandidateId() {
		return candidateId;
	}
	public String getName() {
		return name;
	}
	public String getParty() {
		return party;
	}
	public int getVotes() {
		return votes;
	}
	
	

}
