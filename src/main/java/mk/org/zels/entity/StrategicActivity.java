/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mk.org.zels.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author georgy
 */
@Entity
@Table(name = "strategic_activity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StrategicActivity.findAll", query = "SELECT s FROM StrategicActivity s")
    , @NamedQuery(name = "StrategicActivity.findBySaId", query = "SELECT s FROM StrategicActivity s WHERE s.saId = :saId")
    , @NamedQuery(name = "StrategicActivity.findByName", query = "SELECT s FROM StrategicActivity s WHERE s.name = :name")})
public class StrategicActivity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sa_id", nullable = false)
    private Integer saId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @OneToMany(mappedBy = "strategicActivitiesId")
    private Collection<Activity> activityCollection;
    @JoinColumn(name = "strategy_id_", referencedColumnName = "strategy_id")
    @ManyToOne
    private Strategy strategyId;

    public StrategicActivity() {
    }

    public StrategicActivity(Integer saId) {
        this.saId = saId;
    }

    public StrategicActivity(Integer saId, String name) {
        this.saId = saId;
        this.name = name;
    }

    public Integer getSaId() {
        return saId;
    }

    public void setSaId(Integer saId) {
        this.saId = saId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Activity> getActivityCollection() {
        return activityCollection;
    }

    public void setActivityCollection(Collection<Activity> activityCollection) {
        this.activityCollection = activityCollection;
    }

    public Strategy getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Strategy strategyId) {
        this.strategyId = strategyId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (saId != null ? saId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StrategicActivity)) {
            return false;
        }
        StrategicActivity other = (StrategicActivity) object;
        if ((this.saId == null && other.saId != null) || (this.saId != null && !this.saId.equals(other.saId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getName();
    }

}
