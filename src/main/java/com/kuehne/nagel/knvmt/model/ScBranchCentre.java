package com.kuehne.nagel.knvmt.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the sc_branch_centre database table.
 * 
 */
@Entity
@Table(name="sc_branch_centre")
@NamedQuery(name="ScBranchCentre.findAll", query="SELECT s FROM ScBranchCentre s")
public class ScBranchCentre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private Boolean active;

	@Column(name="create_user")
	private String createUser;

	private Timestamp created;

	private String description;

	private Timestamp modified;

	private String name;

	@Column(name="short_identifier")
	private String shortIdentifier;

	private Long trace;

	@Column(name="update_user")
	private String updateUser;

	//bi-directional many-to-one association to COffice
	@ManyToOne
	@JoinColumn(name="c_office_id")
	private COffice COffice;

	//bi-directional many-to-one association to CProfitCentre
	@ManyToOne
	@JoinColumn(name="c_profit_centre_id")
	private CProfitCentre CProfitCentre;

	//bi-directional many-to-one association to ScHeadcount
	@OneToMany(mappedBy="scBranchCentre")
	private List<ScHeadcount> scHeadcounts;

	public ScBranchCentre() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getModified() {
		return this.modified;
	}

	public void setModified(Timestamp modified) {
		this.modified = modified;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortIdentifier() {
		return this.shortIdentifier;
	}

	public void setShortIdentifier(String shortIdentifier) {
		this.shortIdentifier = shortIdentifier;
	}

	public Long getTrace() {
		return this.trace;
	}

	public void setTrace(Long trace) {
		this.trace = trace;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public COffice getCOffice() {
		return this.COffice;
	}

	public void setCOffice(COffice COffice) {
		this.COffice = COffice;
	}

	public CProfitCentre getCProfitCentre() {
		return this.CProfitCentre;
	}

	public void setCProfitCentre(CProfitCentre CProfitCentre) {
		this.CProfitCentre = CProfitCentre;
	}

	public List<ScHeadcount> getScHeadcounts() {
		return this.scHeadcounts;
	}

	public void setScHeadcounts(List<ScHeadcount> scHeadcounts) {
		this.scHeadcounts = scHeadcounts;
	}

	public ScHeadcount addScHeadcount(ScHeadcount scHeadcount) {
		getScHeadcounts().add(scHeadcount);
		scHeadcount.setScBranchCentre(this);

		return scHeadcount;
	}

	public ScHeadcount removeScHeadcount(ScHeadcount scHeadcount) {
		getScHeadcounts().remove(scHeadcount);
		scHeadcount.setScBranchCentre(null);

		return scHeadcount;
	}

}