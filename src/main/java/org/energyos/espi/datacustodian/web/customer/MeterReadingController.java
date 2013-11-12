/*
 * Copyright 2013 EnergyOS.org
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.energyos.espi.datacustodian.web.customer;

import org.energyos.espi.common.domain.Routes;
import org.energyos.espi.datacustodian.service.MeterReadingService;
import org.energyos.espi.datacustodian.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping()
public class MeterReadingController extends BaseController {

    @Autowired
    protected MeterReadingService meterReadingService;

    @RequestMapping(value = Routes.METER_READINGS_SHOW, method = RequestMethod.GET)
    public String show(@PathVariable Long meterReadingId, ModelMap model) {
        model.put("meterReading", meterReadingService.findById(meterReadingId));
        return "/customer/meterreadings/show";
    }

    public void setMeterReadingService(MeterReadingService meterReadingService) {
        this.meterReadingService = meterReadingService;
    }
}