/*
 * RHQ Management Platform
 * Copyright (C) 2005-2010 Red Hat, Inc.
 * All rights reserved.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation version 2 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */
package org.rhq.enterprise.gui.coregui.client.dashboard.portlets.platform;

import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.data.fields.DataSourceImageField;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;
import com.smartgwt.client.widgets.grid.ListGridRecord;

import org.rhq.core.domain.resource.Resource;
import org.rhq.enterprise.gui.coregui.client.inventory.resource.ResourceDatasource;

/**
 * @author Greg Hinkle
 */
public class PlatformMetricDataSource extends ResourceDatasource {

    PlatformPortletView view;

    public PlatformMetricDataSource(PlatformPortletView view) {
        super();
        this.view = view;

        DataSourceTextField cpuField = new DataSourceTextField("cpu","CPU");
        addField(cpuField);
        DataSourceTextField memoryField = new DataSourceTextField("memory", "Memory");
        addField(memoryField);
        DataSourceTextField swapField = new DataSourceTextField("swap", "Swap");
        // todo swap
    }



    @Override
    public ListGridRecord copyValues(Resource from) {
        ListGridRecord record = super.copyValues(from);

        view.loadMetricsForResource(from, record);
        return record;
    }
}