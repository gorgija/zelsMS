/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mk.org.zels.entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author georgy
 */
@Entity
@Table(name = "activity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Activity.findAll", query = "SELECT a FROM Activity a")
    , @NamedQuery(name = "Activity.findByActivityId", query = "SELECT a FROM Activity a WHERE a.activityId = :activityId")
    , @NamedQuery(name = "Activity.findByName", query = "SELECT a FROM Activity a WHERE a.name = :name")
    , @NamedQuery(name = "Activity.findByDescription", query = "SELECT a FROM Activity a WHERE a.description = :description")
    , @NamedQuery(name = "Activity.findByStart", query = "SELECT a FROM Activity a WHERE a.start = :start")
    , @NamedQuery(name = "Activity.findByEnd", query = "SELECT a FROM Activity a WHERE a.end = :end")
    , @NamedQuery(name = "Activity.findByIndikator", query = "SELECT a FROM Activity a WHERE a.indikator = :indikator")
    , @NamedQuery(name = "Activity.findByStatus", query = "SELECT a FROM Activity a WHERE a.status = :status")
    , @NamedQuery(name = "Activity.findByCompleted", query = "SELECT a FROM Activity a WHERE a.completed = :completed")
    , @NamedQuery(name = "Activity.findByCreatedAt", query = "SELECT a FROM Activity a WHERE a.createdAt = :createdAt")})
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "activity_id", nullable = false)
    private Integer activityId;
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
    @Size(max = 255)
    @Column(name = "indikator", length = 255)
    private String indikator;
    @Size(max = 255)
    @Column(name = "status", length = 255)
    private String status;
    @Column(name = "completed")
    private Short completed;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @OneToMany(mappedBy = "activityId")
    private Collection<Comments> commentsCollection;
    @JoinColumn(name = "strategic_activities_id", referencedColumnName = "sa_id")
    @ManyToOne
    private StrategicActivity strategicActivitiesId;
    @JoinColumn(name = "strategy_id", referencedColumnName = "strategy_id")
    @ManyToOne
    private Strategy strategyId;
    @OneToMany(mappedBy = "activityId")
    private Collection<Files> filesCollection;
    @OneToMany(mappedBy = "activityId")
    private Collection<Tasks> tasksCollection;

    public Activity() {
    }

    public Activity(Integer activityId) {
        this.activityId = activityId;
    }

    public Activity(Integer activityId, String name, Date start, Date end) {
        this.activityId = activityId;
        this.name = name;
        this.start = start;
        this.end = end;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
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

    public String getIndikator() {
        return indikator;
    }

    public void setIndikator(String indikator) {
        this.indikator = indikator;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Short getCompleted() {
        return completed;
    }

    public void setCompleted(Short completed) {
        this.completed = completed;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @XmlTransient
    public Collection<Comments> getCommentsCollection() {
        return commentsCollection;
    }

    public void setCommentsCollection(Collection<Comments> commentsCollection) {
        this.commentsCollection = commentsCollection;
    }

    public StrategicActivity getStrategicActivitiesId() {
        return strategicActivitiesId;
    }

    public void setStrategicActivitiesId(StrategicActivity strategicActivitiesId) {
        this.strategicActivitiesId = strategicActivitiesId;
    }

    public Strategy getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Strategy strategyId) {
        this.strategyId = strategyId;
    }

    @XmlTransient
    public Collection<Files> getFilesCollection() {
        return filesCollection;
    }

    public void setFilesCollection(Collection<Files> filesCollection) {
        this.filesCollection = filesCollection;
    }

    @XmlTransient
    public Collection<Tasks> getTasksCollection() {
        return tasksCollection;
    }

    public void setTasksCollection(Collection<Tasks> tasksCollection) {
        this.tasksCollection = tasksCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (activityId != null ? activityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Activity)) {
            return false;
        }
        Activity other = (Activity) object;
        if ((this.activityId == null && other.activityId != null) || (this.activityId != null && !this.activityId.equals(other.activityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mk.org.zels.entity.Activity[ activityId=" + activityId + " ]";
    }

}
