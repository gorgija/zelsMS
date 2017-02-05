/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mk.org.zels.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author georgy
 */
@Entity
@Table(name = "trenings")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trenings.findAll", query = "SELECT t FROM Trenings t")
    , @NamedQuery(name = "Trenings.findByTreningId", query = "SELECT t FROM Trenings t WHERE t.treningId = :treningId")
    , @NamedQuery(name = "Trenings.findByName", query = "SELECT t FROM Trenings t WHERE t.name = :name")
    , @NamedQuery(name = "Trenings.findByDescription", query = "SELECT t FROM Trenings t WHERE t.description = :description")
    , @NamedQuery(name = "Trenings.findByStart", query = "SELECT t FROM Trenings t WHERE t.start = :start")
    , @NamedQuery(name = "Trenings.findByEnd", query = "SELECT t FROM Trenings t WHERE t.end = :end")
    , @NamedQuery(name = "Trenings.findByCreatedAt", query = "SELECT t FROM Trenings t WHERE t.createdAt = :createdAt")})
public class Trenings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "trening_id", nullable = false)
    private Integer treningId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Size(max = 255)
    @Column(name = "description", length = 255)
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date start;
    @Basic(optional = false)
    @NotNull
    @Column(name = "end", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date end;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @JoinColumn(name = "team_members_id", referencedColumnName = "team_id")
    @ManyToOne
    private Teams teamMembersId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne
    private Users userId;

    public Trenings() {
    }

    public Trenings(Integer treningId) {
        this.treningId = treningId;
    }

    public Trenings(Integer treningId, String name, Date start, Date end) {
        this.treningId = treningId;
        this.name = name;
        this.start = start;
        this.end = end;
    }

    public Integer getTreningId() {
        return treningId;
    }

    public void setTreningId(Integer treningId) {
        this.treningId = treningId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Teams getTeamMembersId() {
        return teamMembersId;
    }

    public void setTeamMembersId(Teams teamMembersId) {
        this.teamMembersId = teamMembersId;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (treningId != null ? treningId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trenings)) {
            return false;
        }
        Trenings other = (Trenings) object;
        if ((this.treningId == null && other.treningId != null) || (this.treningId != null && !this.treningId.equals(other.treningId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mk.org.zels.entity.Trenings[ treningId=" + treningId + " ]";
    }

}
