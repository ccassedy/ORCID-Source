package org.orcid.core.manager.read_only.impl;

import javax.annotation.Resource;

import org.orcid.core.adapter.JpaJaxbNameAdapter;
import org.orcid.core.manager.read_only.RecordNameManagerReadOnly;
import org.orcid.core.utils.RecordNameUtils;
import org.orcid.jaxb.model.record_v2.Name;
import org.orcid.persistence.dao.RecordNameDao;
import org.orcid.persistence.jpa.entities.RecordNameEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Angel Montenegro
 * 
 */
public class RecordNameManagerReadOnlyImpl extends ManagerReadOnlyBaseImpl implements RecordNameManagerReadOnly {

    private static final Logger LOGGER = LoggerFactory.getLogger(RecordNameManagerReadOnlyImpl.class);
    
    @Resource
    protected JpaJaxbNameAdapter jpaJaxbNameAdapter;
    
    protected RecordNameDao recordNameDao;        
    
    public void setRecordNameDao(RecordNameDao recordNameDao) {
        this.recordNameDao = recordNameDao;
    }
    
    @Override
    public Name getRecordName(String orcid) {
        try {
            return jpaJaxbNameAdapter.toName(recordNameDao.getRecordName(orcid, getLastModified(orcid)));             
        } catch(Exception e) {
            LOGGER.error("Exception getting record name", e);
        }
        return null;
    }

    @Override
    public Name findByCreditName(String creditName) {
        try {
            return jpaJaxbNameAdapter.toName(recordNameDao.findByCreditName(creditName));
        } catch(Exception e) {
            LOGGER.error("Exception getting record name by credit name", e);
        }
        return null;
    }

    @Override
    public boolean exists(String orcid) {        
        return recordNameDao.exists(orcid);
    }

    @Override
    public String fetchDisplayableCreditName(String orcid) {
        RecordNameEntity recordName = recordNameDao.getRecordName(orcid, getLastModified(orcid));
        return RecordNameUtils.getCreditName(recordName);
    } 
    
    @Override
    public String fetchDisplayableUserName(String orcid) {
        RecordNameEntity recordName = recordNameDao.getRecordName(orcid, getLastModified(orcid));
        return RecordNameUtils.getCreditName(recordName);
    }

    @Override
    public String fetchDisplayablePublicName(String orcid) {
        RecordNameEntity recordName = recordNameDao.getRecordName(orcid, getLastModified(orcid));
        return RecordNameUtils.getPublicName(recordName);
    }

    @Override
    public String fetchDisplayableDisplayName(String orcid) {
        RecordNameEntity recordName = recordNameDao.getRecordName(orcid, getLastModified(orcid));
        return RecordNameUtils.getDisplayName(recordName);
    }
}
