package cachet.apps.location_background.data;

import cachet.apps.location_background.utils.LocaleConverter;

import java.util.Locale;
import java.util.Map;

public class ReverseGeocodingOptions extends GeocodingOptions {
  private Coordinate mCoordinate;

  private ReverseGeocodingOptions(Coordinate coordinate, Locale locale) {
    super(locale);

    mCoordinate = coordinate;
  }

  public Coordinate getCoordinate() {
    return mCoordinate;
  }

  public static ReverseGeocodingOptions parseArguments(Object arguments) {
    @SuppressWarnings("unchecked")
    Map<String, Object> argumentMap = (Map<String, Object>) arguments;

    Locale locale = null;
    Coordinate coordinate = new Coordinate(
        (double) argumentMap.get("latitude"),
        (double) argumentMap.get("longitude"));

    if (argumentMap.containsKey("localeIdentifier")) {
      locale = LocaleConverter.fromLanguageTag((String) argumentMap.get("localeIdentifier"));
    }

    return new ReverseGeocodingOptions(coordinate, locale);
  }
}
