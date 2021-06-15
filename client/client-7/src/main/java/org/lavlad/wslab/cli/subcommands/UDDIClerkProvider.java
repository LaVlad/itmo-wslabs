package org.lavlad.wslab.cli.subcommands;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.juddi.v3.client.config.UDDIClerk;
import org.apache.juddi.v3.client.config.UDDIClient;
import org.lavlad.wslab.exception.WslabConfigurationException;

public class UDDIClerkProvider {

    UDDIClerk getClerk() throws WslabConfigurationException {
        try {
            UDDIClient client = new UDDIClient();
            return client.getClerk("wslab");
        } catch (ConfigurationException e) {
            throw new WslabConfigurationException(e.getLocalizedMessage());
        }
    }

}