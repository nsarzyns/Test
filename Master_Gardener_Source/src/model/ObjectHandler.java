
// Alex - I believe this is all old stuff from Logan's CS320 project, and as such I'm only keeping this here as
// source material for anyone else who believes they need it

package model;

public abstract class ObjectHandler {
	@SuppressWarnings("unchecked")
	public static <T> T castObject(Object obj) {
		if(obj == null)
		{
			return null;
		} else
		{
			return (T) obj;
		}
	}
}