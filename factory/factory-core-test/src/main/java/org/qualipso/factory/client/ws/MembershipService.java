
package org.qualipso.factory.client.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.7-b01-
 * Generated source version: 2.1
 * 
 */
@WebService(name = "MembershipService", targetNamespace = "http://org.qualipso.factory.ws/service/membership")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface MembershipService {


    /**
     * 
     * @param arg1
     * @param arg0
     * @throws MembershipServiceException_Exception
     */
    @WebMethod
    public void addMemberInGroup(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1)
        throws MembershipServiceException_Exception
    ;

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @throws MembershipServiceException_Exception
     */
    @WebMethod
    public void createGroup(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2)
        throws MembershipServiceException_Exception
    ;

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @throws MembershipServiceException_Exception
     */
    @WebMethod
    public void createProfile(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        int arg3)
        throws MembershipServiceException_Exception
    ;

    /**
     * 
     * @param arg0
     * @throws MembershipServiceException_Exception
     */
    @WebMethod
    public void deleteGroup(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws MembershipServiceException_Exception
    ;

    /**
     * 
     * @param arg0
     * @throws MembershipServiceException_Exception
     */
    @WebMethod
    public void deleteProfile(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws MembershipServiceException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns org.qualipso.factory.client.ws.FactoryResource
     * @throws FactoryException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    public FactoryResource findResource(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws FactoryException_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns org.qualipso.factory.client.ws.ProfileInfo
     * @throws MembershipServiceException_Exception
     */
    @WebMethod
    @WebResult(name = "profile-info", partName = "profile-info")
    public ProfileInfo getProfileInfo(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1)
        throws MembershipServiceException_Exception
    ;

    /**
     * 
     * @return
     *     returns java.lang.String
     * @throws MembershipServiceException_Exception
     */
    @WebMethod
    @WebResult(name = "connected-profile-path", partName = "connected-profile-path")
    public String getProfilePathForConnectedIdentifier()
        throws MembershipServiceException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     * @throws MembershipServiceException_Exception
     */
    @WebMethod
    @WebResult(name = "profile-path", partName = "profile-path")
    public String getProfilePathForIdentifier(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws MembershipServiceException_Exception
    ;

    /**
     * 
     * @return
     *     returns java.lang.String
     * @throws MembershipServiceException_Exception
     */
    @WebMethod
    @WebResult(name = "profiles-path", partName = "profiles-path")
    public String getProfilesPath()
        throws MembershipServiceException_Exception
    ;

    /**
     * 
     * @return
     *     returns org.qualipso.factory.client.ws.StringArray
     */
    @WebMethod
    @WebResult(partName = "return")
    public StringArray getResourceTypeList();

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(partName = "return")
    public String getServiceName();

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns boolean
     * @throws MembershipServiceException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    public boolean isMember(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1)
        throws MembershipServiceException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns org.qualipso.factory.client.ws.StringArray
     * @throws MembershipServiceException_Exception
     */
    @WebMethod
    @WebResult(name = "members-list", partName = "members-list")
    public StringArray listMembers(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws MembershipServiceException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns org.qualipso.factory.client.ws.ProfileInfoArray
     * @throws MembershipServiceException_Exception
     */
    @WebMethod
    @WebResult(name = "profile-infos", partName = "profile-infos")
    public ProfileInfoArray listProfileInfos(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws MembershipServiceException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns org.qualipso.factory.client.ws.Group
     * @throws MembershipServiceException_Exception
     */
    @WebMethod
    @WebResult(name = "group", partName = "group")
    public Group readGroup(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws MembershipServiceException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns org.qualipso.factory.client.ws.Profile
     * @throws MembershipServiceException_Exception
     */
    @WebMethod
    @WebResult(name = "profile", partName = "profile")
    public Profile readProfile(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws MembershipServiceException_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @throws MembershipServiceException_Exception
     */
    @WebMethod
    public void removeMemberFromGroup(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1)
        throws MembershipServiceException_Exception
    ;

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @throws MembershipServiceException_Exception
     */
    @WebMethod
    public void setProfileInfo(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2)
        throws MembershipServiceException_Exception
    ;

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @throws MembershipServiceException_Exception
     */
    @WebMethod
    public void updateGroup(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2)
        throws MembershipServiceException_Exception
    ;

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @throws MembershipServiceException_Exception
     */
    @WebMethod
    public void updateProfile(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        String arg1,
        @WebParam(name = "arg2", partName = "arg2")
        String arg2,
        @WebParam(name = "arg3", partName = "arg3")
        int arg3)
        throws MembershipServiceException_Exception
    ;

    /**
     * 
     * @param arg0
     * @throws MembershipServiceException_Exception
     */
    @WebMethod
    public void updateProfileLastLoginDate(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws MembershipServiceException_Exception
    ;

    /**
     * 
     * @param arg1
     * @param arg0
     * @throws MembershipServiceException_Exception
     */
    @WebMethod
    public void updateProfileOnlineStatus(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0,
        @WebParam(name = "arg1", partName = "arg1")
        int arg1)
        throws MembershipServiceException_Exception
    ;

}
