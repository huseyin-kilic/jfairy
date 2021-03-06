package io.codearte.jfairy;

import io.codearte.jfairy.data.DataMaster;
import io.codearte.jfairy.producer.RandomGenerator;
import io.codearte.jfairy.producer.VATIdentificationNumberProvider;
import io.codearte.jfairy.producer.company.locale.zh.ZhVATIdentificationNumberProvider;
import io.codearte.jfairy.producer.person.*;
import io.codearte.jfairy.producer.person.locale.NoNationalIdentificationNumberFactory;
import io.codearte.jfairy.producer.person.locale.zh.ZhAddressProvider;
import io.codearte.jfairy.producer.person.locale.zh.ZhNationalIdentityCardNumberProvider;
import io.codearte.jfairy.producer.person.locale.zh.ZhPassportNumberProvider;

import java.util.Random;

/**
 * io.codearte.jfairy.ZhFairyModule
 *
 * @author lhfcws
 * @since 2017/03/01
 */
public class ZhFairyModule extends FairyModule {
	public ZhFairyModule(DataMaster dataMaster, RandomGenerator randomGenerator) {
		super(dataMaster, randomGenerator);
	}

	@Override
	protected void configure() {
		super.configure();

		// Social Insurance Number is the same as ID number in China now
		bind(NationalIdentificationNumberFactory.class).to(NoNationalIdentificationNumberFactory.class);
		bind(NationalIdentityCardNumberProvider.class).to(ZhNationalIdentityCardNumberProvider.class);
		bind(VATIdentificationNumberProvider.class).to(ZhVATIdentificationNumberProvider.class);
		bind(AddressProvider.class).to(ZhAddressProvider.class);
		bind(PassportNumberProvider.class).to(ZhPassportNumberProvider.class);
	}
}
