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
@Table(name = "strategy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Strategy.findAll", query = "SELECT s FROM Strategy s")
    , @NamedQuery(name = "Strategy.findByStrategyId", query = "SELECT s FROM Strategy s WHERE s.strategyId = :strategyId")
    , @NamedQuery(name = "Strategy.findByGoal", query = "SELECT s FROM Strategy s WHERE s.goal = :goal")})
public class Strategy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "strategy_id", nullable = false)
    private Integer strategyId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "goal", nullable = false, length = 255)
    private String goal;
    @OneToMany(mappedBy = "strategyId")
    private Collection<Activity> activityCollection;
    @OneToMany(mappedBy = "strategyId")
    private Collection<StrategicActivity> strategicActivityCollection;

    public Strategy() {
    }

    public Strategy(Integer strategyId) {
        this.strategyId = strategyId;
    }

    public Strategy(Integer strategyId, String goal) {
        this.strategyId = strategyId;
        this.goal = goal;
    }

    public Integer getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Integer strategyId) {
        this.strategyId = strategyId;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    @XmlTransient
    public Collection<Activity> getActivityCollection() {
        return activityCollection;
    }

    public void setActivityCollection(Collection<Activity> activityCollection) {
        this.activityCollection = activityCollection;
    }

    @XmlTransient
    public Collection<StrategicActivity> getStrategicActivityCollection() {
        return strategicActivityCollection;
    }

    public void setStrategicActivityCollection(Collection<StrategicActivity> strategicActivityCollection) {
        this.strategicActivityCollection = strategicActivityCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (strategyId != null ? strategyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Strategy)) {
            return false;
        }
        Strategy other = (Strategy) object;
        if ((this.strategyId == null && other.strategyId != null) || (this.strategyId != null && !this.strategyId.equals(other.strategyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getGoal();
    }

}
