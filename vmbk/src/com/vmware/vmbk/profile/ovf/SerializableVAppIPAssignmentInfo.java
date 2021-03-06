/*******************************************************************************
 * Copyright (C) 2019, VMware Inc
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 ******************************************************************************/
package com.vmware.vmbk.profile.ovf;

import java.io.Serializable;
import java.util.Arrays;

import com.vmware.vim25.VAppIPAssignmentInfo;

class SerializableVAppIPAssignmentInfo implements Serializable {

    private static final long serialVersionUID = -2913840685244044593L;
    private final String ipAllocationPolicy;
    private final String ipProtocol;
    private final String[] supportedAllocationScheme;
    private final String[] supportedIpProtocol;

    SerializableVAppIPAssignmentInfo(final VAppIPAssignmentInfo vAppIPAssignmentInfo) {
	this.ipAllocationPolicy = vAppIPAssignmentInfo.getIpAllocationPolicy();
	this.ipProtocol = vAppIPAssignmentInfo.getIpProtocol();
	this.supportedAllocationScheme = vAppIPAssignmentInfo.getSupportedAllocationScheme().toArray(new String[0]);
	this.supportedIpProtocol = vAppIPAssignmentInfo.getSupportedIpProtocol().toArray(new String[0]);
    }

    VAppIPAssignmentInfo toVAppIPAssignmentInfo() {
	final VAppIPAssignmentInfo vAppIPAssignmentInfo = new VAppIPAssignmentInfo();
	vAppIPAssignmentInfo.setIpAllocationPolicy(this.ipAllocationPolicy);
	vAppIPAssignmentInfo.setIpProtocol(this.ipProtocol);
	vAppIPAssignmentInfo.getSupportedAllocationScheme().addAll(Arrays.asList(this.supportedAllocationScheme));
	vAppIPAssignmentInfo.getSupportedIpProtocol().addAll(Arrays.asList(this.supportedIpProtocol));
	return vAppIPAssignmentInfo;

    }
}
