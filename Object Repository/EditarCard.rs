<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>EditarCard</name>
   <tag></tag>
   <elementGuidId>86f06ea2-dcaa-4ed2-abf1-810f5aa02da0</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <connectionTimeout>-1</connectionTimeout>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <katalonVersion>7.7.2</katalonVersion>
   <maxResponseSize>-1</maxResponseSize>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>PUT</restRequestMethod>
   <restUrl>https://api.trello.com/1/cards/${idCard}?key=${Key}&amp;token=${Token}&amp;idList=${idList}&amp;name=CARD AUTOMATIZADO ALTERADO</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceEndpoint></soapServiceEndpoint>
   <soapServiceFunction></soapServiceFunction>
   <socketTimeout>-1</socketTimeout>
   <useServiceInfoFromWsdl>true</useServiceInfoFromWsdl>
   <variables>
      <defaultValue>GlobalVariable.IdList</defaultValue>
      <description></description>
      <id>5784e996-26c6-47c0-a382-8e0455a72df5</id>
      <masked>false</masked>
      <name>idList</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Token</defaultValue>
      <description></description>
      <id>7a119c5f-792b-49eb-aa9e-4ab5289654cd</id>
      <masked>false</masked>
      <name>Token</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.Key</defaultValue>
      <description></description>
      <id>278a5cc4-1c4b-4b10-91a1-ae778dd3d33c</id>
      <masked>false</masked>
      <name>Key</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.idCard</defaultValue>
      <description></description>
      <id>e4537037-ef76-4544-8a5b-ad7eefa21de4</id>
      <masked>false</masked>
      <name>idCard</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
