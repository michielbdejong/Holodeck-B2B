/**
 * Copyright (C) 2014 The Holodeck B2B Team, Sander Fieten
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.holodeckb2b.interfaces.messagemodel;


import org.holodeckb2b.interfaces.general.IDescription;

/**
 * Represents the information available for a specific error in an error signal message unit.
 * <p>Corresponds to a <code>eb:Error</code> child element of <code>eb:SignalMessage</code>. The structure of this
 * element is specified in section 6.2 of the ebMS Core Specification.
 *
 * @author Sander Fieten (sander at holodeck-b2b.org)
 */
public interface IEbmsError {

    /**
     * The defined error severities in the ebMS specification (see §6.2.5).
     */
    public enum Severity {
        WARNING,
        FAILURE
    }

    /**
     * Gets the REQUIRED error code. The error codes for errors that occur in the processing of ebMS messages are
     * defined in the ebMS specifications (Core, Part 2 and AS4). These error codes all start with the "EBMS:" prefix.
     * When the error signal is used for signaling errors that originate from outside the ebMS processing the error code
     * should have another prefix.
     * <p>Corresponds to the <code>errorCode</code> attribute of the <code>eb:Error</code> element.
     *
     * @return  The error code of this error
     */
    public String getErrorCode();

    /**
     * Get the REQUIRED severity of the error, which can be either <i>warning</i> or <i>failure</i>. For ebMS error the
     * specification recommends a default severity to use, but depending on the situation it can be changed.
     * <p>Corresponds to the <code>severity</code> attribute of <code>eb:Error</code> element.
     *
     * @return  The severity assigned to the error
     */
    public Severity getSeverity();

    /**
     * Gets the OPTIONAL error message. This a short description of the error that occurred. The ebMS specification
     * describes default values for ebMS errors. Context information can be given using the <i>error detail</i> and
     * <i>long description</i> fields.
     * <p>Corresponds to the <code>shortDescription</code> attribute of <code>eb:Error</code> element.
     *
     * @return  The error message summarizing the error that occurred
     */
    public String getMessage();

    /**
     * Gets the OPTIONAL functional module where the error originated from. For error that occur during the processing
     * of the ebMS message the specification defines default values. Other values may be used to indicate the error did
     * not occur in ebMS message processing.
     * <p>Corresponds to the <code>origin</code> attribute of <code>eb:Error</code> element.
     *
     * @return  Identification of the functional module in which the error occurred.
     */
    public String getOrigin();

    /**
     * Gets the OPTIONAL error category that identifies the type of error in relation to the origin of error. For ebMS
     * errors default values are given in the ebMS specifications.
     * <p>Corresponds to the <code>category</code> attribute of <code>eb:Error</code> element.
     *
     * @return The category of the error
     */
    public String getCategory();

    /**
     * Gets the reference to, i.e. the <code>MessageId</code> of, the message unit in error. This field is defined as
     * optional in the specification, but it RECOMMENDED to use it when the error can be related to a message unit.
     * <p>Corresponds to the <code>refToMessageInError</code> attribute of <code>eb:Error</code> element.
     *
     * @return If a message unit caused the error, the <code>messageId</code> of that message unit<br>
     *         <code>null</code> if the error is not related to a message unit
     */
    public String getRefToMessageInError();

    /**
     * Gets the OPTIONAL detailed error message that can be used to give more information about the cause of the error.
     * For errors generated by Holodeck B2B this information is not used.
     * <p>Corresponds to the <code>ErrorDetail</code> child element of <code>eb:Error</code>.
     *
     * @return The detailed error message
     */
    public String getErrorDetail();

    /**
     * Gets an OPTIONAL extended error description of the error. Like the error detail information the description is
     * not used for error generated by Holodeck B2B.
     * <p>Corresponds to the <code>eb:Description</code> child element of  <code>eb:Error</code>.
     *
     * @return An {@link IDescription} object containing the description of the error
     */
    public IDescription getDescription();
}
