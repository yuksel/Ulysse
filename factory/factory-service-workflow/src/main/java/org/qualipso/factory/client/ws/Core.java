
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
@WebService(name = "core", targetNamespace = "http://org.qualipso.factory.ws/service/core")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Core {


    /**
     * 
     * @param description
     * @param path
     * @param filename
     * @param contentType
     * @param fileData
     * @throws PathAlreadyBoundException_Exception
     * @throws InvalidPathException_Exception
     * @throws AccessDeniedException_Exception
     * @throws CoreServiceException_Exception
     */
    @WebMethod
    public void createFile(
        @WebParam(name = "path", partName = "path")
        String path,
        @WebParam(name = "filename", partName = "filename")
        String filename,
        @WebParam(name = "content-type", partName = "content-type")
        String contentType,
        @WebParam(name = "description", partName = "description")
        String description,
        @WebParam(name = "file-data", partName = "file-data")
        FileData fileData)
        throws AccessDeniedException_Exception, CoreServiceException_Exception, InvalidPathException_Exception, PathAlreadyBoundException_Exception
    ;

    /**
     * 
     * @param description
     * @param name
     * @param path
     * @throws PathAlreadyBoundException_Exception
     * @throws InvalidPathException_Exception
     * @throws CoreServiceException_Exception
     * @throws AccessDeniedException_Exception
     */
    @WebMethod
    public void createFolder(
        @WebParam(name = "path", partName = "path")
        String path,
        @WebParam(name = "name", partName = "name")
        String name,
        @WebParam(name = "description", partName = "description")
        String description)
        throws AccessDeniedException_Exception, CoreServiceException_Exception, InvalidPathException_Exception, PathAlreadyBoundException_Exception
    ;

    /**
     * 
     * @param toPath
     * @param path
     * @throws PathAlreadyBoundException_Exception
     * @throws InvalidPathException_Exception
     * @throws AccessDeniedException_Exception
     * @throws CoreServiceException_Exception
     */
    @WebMethod
    public void createLink(
        @WebParam(name = "path", partName = "path")
        String path,
        @WebParam(name = "to-path", partName = "to-path")
        String toPath)
        throws AccessDeniedException_Exception, CoreServiceException_Exception, InvalidPathException_Exception, PathAlreadyBoundException_Exception
    ;

    /**
     * 
     * @param path
     * @throws PathNotFoundException_Exception
     * @throws InvalidPathException_Exception
     * @throws PathNotEmptyException_Exception
     * @throws AccessDeniedException_Exception
     * @throws CoreServiceException_Exception
     */
    @WebMethod
    public void deleteFile(
        @WebParam(name = "path", partName = "path")
        String path)
        throws AccessDeniedException_Exception, CoreServiceException_Exception, InvalidPathException_Exception, PathNotEmptyException_Exception, PathNotFoundException_Exception
    ;

    /**
     * 
     * @param path
     * @throws PathNotFoundException_Exception
     * @throws InvalidPathException_Exception
     * @throws PathNotEmptyException_Exception
     * @throws AccessDeniedException_Exception
     * @throws CoreServiceException_Exception
     */
    @WebMethod
    public void deleteFolder(
        @WebParam(name = "path", partName = "path")
        String path)
        throws AccessDeniedException_Exception, CoreServiceException_Exception, InvalidPathException_Exception, PathNotEmptyException_Exception, PathNotFoundException_Exception
    ;

    /**
     * 
     * @param path
     * @throws PathNotFoundException_Exception
     * @throws InvalidPathException_Exception
     * @throws PathNotEmptyException_Exception
     * @throws AccessDeniedException_Exception
     * @throws CoreServiceException_Exception
     */
    @WebMethod
    public void deleteLink(
        @WebParam(name = "path", partName = "path")
        String path)
        throws AccessDeniedException_Exception, CoreServiceException_Exception, InvalidPathException_Exception, PathNotEmptyException_Exception, PathNotFoundException_Exception
    ;

    /**
     * 
     * @param arg0
     * @return
     *     returns org.qualipso.factory.client.ws.FactoryResource
     * @throws PathNotFoundException_Exception
     * @throws InvalidPathException_Exception
     * @throws FactoryException_Exception
     * @throws AccessDeniedException_Exception
     */
    @WebMethod
    @WebResult(partName = "return")
    public FactoryResource findResource(
        @WebParam(name = "arg0", partName = "arg0")
        String arg0)
        throws AccessDeniedException_Exception, FactoryException_Exception, InvalidPathException_Exception, PathNotFoundException_Exception
    ;

    /**
     * 
     * @param path
     * @return
     *     returns org.qualipso.factory.client.ws.FileData
     * @throws PathNotFoundException_Exception
     * @throws InvalidPathException_Exception
     * @throws CoreServiceException_Exception
     * @throws AccessDeniedException_Exception
     */
    @WebMethod
    @WebResult(name = "file-data", partName = "file-data")
    public FileData getFileData(
        @WebParam(name = "path", partName = "path")
        String path)
        throws AccessDeniedException_Exception, CoreServiceException_Exception, InvalidPathException_Exception, PathNotFoundException_Exception
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
     * @param path
     * @return
     *     returns org.qualipso.factory.client.ws.File
     * @throws PathNotFoundException_Exception
     * @throws InvalidPathException_Exception
     * @throws AccessDeniedException_Exception
     * @throws CoreServiceException_Exception
     */
    @WebMethod
    @WebResult(name = "file", partName = "file")
    public File readFile(
        @WebParam(name = "path", partName = "path")
        String path)
        throws AccessDeniedException_Exception, CoreServiceException_Exception, InvalidPathException_Exception, PathNotFoundException_Exception
    ;

    /**
     * 
     * @param path
     * @return
     *     returns org.qualipso.factory.client.ws.Folder
     * @throws PathNotFoundException_Exception
     * @throws InvalidPathException_Exception
     * @throws AccessDeniedException_Exception
     * @throws CoreServiceException_Exception
     */
    @WebMethod
    @WebResult(name = "folder", partName = "folder")
    public Folder readFolder(
        @WebParam(name = "path", partName = "path")
        String path)
        throws AccessDeniedException_Exception, CoreServiceException_Exception, InvalidPathException_Exception, PathNotFoundException_Exception
    ;

    /**
     * 
     * @param path
     * @return
     *     returns org.qualipso.factory.client.ws.Link
     * @throws PathNotFoundException_Exception
     * @throws InvalidPathException_Exception
     * @throws CoreServiceException_Exception
     * @throws AccessDeniedException_Exception
     */
    @WebMethod
    @WebResult(name = "link", partName = "link")
    public Link readLink(
        @WebParam(name = "path", partName = "path")
        String path)
        throws AccessDeniedException_Exception, CoreServiceException_Exception, InvalidPathException_Exception, PathNotFoundException_Exception
    ;

    /**
     * 
     * @param description
     * @param path
     * @param filename
     * @param contentType
     * @param fileData
     * @throws PathNotFoundException_Exception
     * @throws InvalidPathException_Exception
     * @throws AccessDeniedException_Exception
     * @throws CoreServiceException_Exception
     */
    @WebMethod
    public void updateFile(
        @WebParam(name = "path", partName = "path")
        String path,
        @WebParam(name = "filename", partName = "filename")
        String filename,
        @WebParam(name = "content-type", partName = "content-type")
        String contentType,
        @WebParam(name = "description", partName = "description")
        String description,
        @WebParam(name = "file-data", partName = "file-data")
        FileData fileData)
        throws AccessDeniedException_Exception, CoreServiceException_Exception, InvalidPathException_Exception, PathNotFoundException_Exception
    ;

    /**
     * 
     * @param description
     * @param name
     * @param path
     * @throws PathNotFoundException_Exception
     * @throws InvalidPathException_Exception
     * @throws AccessDeniedException_Exception
     * @throws CoreServiceException_Exception
     */
    @WebMethod
    public void updateFolder(
        @WebParam(name = "path", partName = "path")
        String path,
        @WebParam(name = "name", partName = "name")
        String name,
        @WebParam(name = "description", partName = "description")
        String description)
        throws AccessDeniedException_Exception, CoreServiceException_Exception, InvalidPathException_Exception, PathNotFoundException_Exception
    ;

    /**
     * 
     * @param toPath
     * @param path
     * @throws PathNotFoundException_Exception
     * @throws InvalidPathException_Exception
     * @throws AccessDeniedException_Exception
     * @throws CoreServiceException_Exception
     */
    @WebMethod
    public void updateLink(
        @WebParam(name = "path", partName = "path")
        String path,
        @WebParam(name = "to-path", partName = "to-path")
        String toPath)
        throws AccessDeniedException_Exception, CoreServiceException_Exception, InvalidPathException_Exception, PathNotFoundException_Exception
    ;

}
