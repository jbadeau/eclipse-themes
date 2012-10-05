package net.jeeeyul.eclipse.themes;

import org.eclipse.core.runtime.Platform;
import org.eclipse.osgi.service.resolver.VersionRange;
import org.osgi.framework.Bundle;
import org.osgi.framework.Constants;
import org.osgi.framework.Version;

public class E4Platform {
	public static final E4Platform INSTANCE = new E4Platform();

	public static final VersionRange JUNO_RANGE = new VersionRange("[4.2.0, 4.2.1)");
	public static final VersionRange JUNO_SR1_RANGE = new VersionRange("[4.2.1, 4.2.2)");

	private Version version;

	public Version getVersion() {
		if (version == null) {
			Bundle bundle = Platform.getBundle("org.eclipse.platform");
			String versionString = bundle.getHeaders().get(Constants.BUNDLE_VERSION);
			version = new Version(versionString);
		}
		return version;
	}

	public boolean isJunoSR1() {
		return JUNO_SR1_RANGE.isIncluded(getVersion());
	}

}
