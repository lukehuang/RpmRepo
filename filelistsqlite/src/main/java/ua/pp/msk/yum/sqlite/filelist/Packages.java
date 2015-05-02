/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.pp.msk.yum.sqlite.filelist;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 *
 * @author Maksym Shkolnyi aka maskimko
 */
@Entity(name = "primaryPackages")
@Table(name = "packages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Packages.findAll", query = "SELECT p FROM Packages p"),
    @NamedQuery(name = "Packages.findByPkgKey", query = "SELECT p FROM Packages p WHERE p.pkgKey = :pkgKey"),
    @NamedQuery(name = "Packages.findByPkgId", query = "SELECT p FROM Packages p WHERE p.pkgId = :pkgId")})
public class Packages implements Serializable {

    
 
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "pkgKey")
    private Integer pkgKey;
   
    @OneToMany(mappedBy = "pkgKey")
    private Collection<Filelist> filelistCollection;

    public Packages() {
    }

    public Integer getPkgKey() {
        return pkgKey;
    }

    public void setPkgKey(Integer pkgKey) {
        this.pkgKey = pkgKey;
    }

 

    @XmlTransient
    public Collection<Filelist> getFilelistCollection() {
        return filelistCollection;
    }

    public void setFilelistCollection(Collection<Filelist> filelist1Collection) {
        this.filelistCollection = filelist1Collection;
    }

 

}
