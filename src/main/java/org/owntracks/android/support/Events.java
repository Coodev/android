package org.owntracks.android.support;

import java.util.Date;

import org.owntracks.android.db.Waypoint;
import org.owntracks.android.messages.ConfigurationMessage;
import org.owntracks.android.messages.WaypointMessage;
import org.owntracks.android.model.Contact;
import org.owntracks.android.model.GeocodableLocation;
import org.owntracks.android.messages.LocationMessage;
import org.owntracks.android.services.ServiceBroker;
import org.owntracks.android.services.ServiceLocator;

import android.location.Location;

public class Events {



	public static class WaypointTransition extends E {
		Waypoint w;
		int transition;

		public WaypointTransition(Waypoint w, int transition) {
			super();
			this.w = w;
			this.transition = transition;
		}

		public Waypoint getWaypoint() {
			return this.w;
		}

		public int getTransition() {
			return this.transition;
		}

	}

	public static class WaypointAddedByUser extends E {
		Waypoint w;

		public WaypointAddedByUser(Waypoint w) {
			super();
			this.w = w;
		}

		public Waypoint getWaypoint() {
			return this.w;
		}

	}
    public static class WaypointAdded extends E {
        Waypoint w;

        public WaypointAdded(Waypoint w) {
            super();
            this.w = w;
        }

        public Waypoint getWaypoint() {
            return this.w;
        }

    }


    public static class WaypointUpdated extends E {
        Waypoint w;

        public WaypointUpdated(Waypoint w) {
            super();
            this.w = w;
        }

        public Waypoint getWaypoint() {
            return this.w;
        }

    }

    public static class WaypointUpdatedByUser extends E {
        Waypoint w;

        public WaypointUpdatedByUser(Waypoint w) {
            super();
            this.w = w;
        }

        public Waypoint getWaypoint() {
            return this.w;
        }

    }


	public static class WaypointRemoved extends E {
		Waypoint w;

		public WaypointRemoved(Waypoint w) {
			super();
			this.w = w;
		}

		public Waypoint getWaypoint() {
			return this.w;
		}

	}

	public static abstract class E {
		Date date;

		public E() {
			this.date = new Date();
		}

		public Date getDate() {
			return this.date;
		}

	}

	public static class Dummy extends E {
		public Dummy() {
		}
	}

	public static class PublishSuccessfull extends E {
		Object extra;

		public PublishSuccessfull(Object extra) {
			super();
			this.extra = extra;
		}

		public Object getExtra() {
			return this.extra;
		}
	}

	public static class CurrentLocationUpdated extends E {
		GeocodableLocation l;

		public CurrentLocationUpdated(Location l) {
			super();
			this.l = new GeocodableLocation(l);
		}

		public CurrentLocationUpdated(GeocodableLocation l) {
			this.l = l;
		}

		public GeocodableLocation getGeocodableLocation() {
			return this.l;
		}

	}

	public static class ContactAdded extends E {
		Contact contact;

		public ContactAdded(Contact f) {
			super();
			this.contact = f;
		}

		public Contact getContact() {
			return this.contact;
		}

	}

	public static class LocationMessageReceived extends E {
		private String t;
		private LocationMessage m;

		public LocationMessageReceived(LocationMessage m, String t) {
			super();
			this.t = t;
			this.m = m;
		}

		public String getTopic() {
			return this.t;
		}

		public LocationMessage getLocationMessage() {
			return this.m;
		}

		public GeocodableLocation getGeocodableLocation() {
			return this.m.getLocation();
		}
	}

    public static class WaypointMessageReceived extends E {
        private String t;
        private WaypointMessage m;

        public WaypointMessageReceived(WaypointMessage m, String t) {
            super();
            this.t = t;
            this.m = m;
        }

        public String getTopic() {
            return this.t;
        }

        public WaypointMessage getLocationMessage() {
            return this.m;
        }
    }

    public static class ConfigurationMessageReceived extends E {
        private String t;
        private ConfigurationMessage m;

        public ConfigurationMessageReceived(ConfigurationMessage m, String t) {
            super();
            this.t = t;
            this.m = m;
        }

        public String getTopic() {
            return this.t;
        }

        public ConfigurationMessage getConfigurationMessage() {
            return this.m;
        }
    }


    public static class ContactUpdated extends E {
		private Contact c;

		public ContactUpdated(Contact c) {
			super();
			this.c = c;
		}

		public Contact getContact() {
			return this.c;
		}

	}
	
	public static class BrokerChanged extends E {
		public BrokerChanged() {}
	}

	public static class StateChanged {
		public static class ServiceBroker extends E {
			private org.owntracks.android.services.ServiceBroker.State state;
			private Object extra;

			public ServiceBroker(org.owntracks.android.services.ServiceBroker.State state) {
				this(state, null);
			}

			public ServiceBroker(org.owntracks.android.services.ServiceBroker.State state,
					Object extra) {
				super();
				this.state = state;
				this.extra = extra;
			}

			public org.owntracks.android.services.ServiceBroker.State getState() {
				return this.state;
			}

			public Object getExtra() {
				return this.extra;
			}

		}

        public static class ServiceLocator extends E {
            private org.owntracks.android.services.ServiceLocator.State state;

            public ServiceLocator(org.owntracks.android.services.ServiceLocator.State state) {
                this.state = state;
            }

            public org.owntracks.android.services.ServiceLocator.State getState() {
                return this.state;
            }

        }

        public static class ServiceBeacon extends E {
            private org.owntracks.android.services.ServiceBeacon.State state;

            public ServiceBeacon(org.owntracks.android.services.ServiceBeacon.State state) {
                this.state = state;
            }

            public org.owntracks.android.services.ServiceBeacon.State getState() {
                return this.state;
            }

        }
	}

}
