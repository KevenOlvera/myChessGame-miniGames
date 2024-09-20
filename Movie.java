package BitBlitz;

public class Movie 
{
	//features
	String name;
	int releaseYear;
	boolean animation;
	boolean liveAction;
	boolean comedy;
	boolean action;
	boolean historical;
	boolean characterFocused;
	boolean groupFocused;
	boolean display;
	
	//methods
	public void setName (String theName)
	{
		name = theName;
	}
	public String getName ()
	{
		return name;
	}
	public void setReleaseYear (int theReleaseYear)
	{
		releaseYear = theReleaseYear;
	}
	public int getReleaseYear ()
	{
		return releaseYear;
	}
	public void setAnimation (boolean animation)
	{
		this.animation = animation;
	}
	public boolean getAnimation ()
	{
		return animation;
	}
	public void setLiveAction (boolean liveAction)
	{
		this.liveAction = liveAction;
	}
	public boolean getLiveAction ()
	{
		return liveAction;
	}
	public void setComedy (boolean comedy)
	{
		this.comedy = comedy;
	}
	public boolean getComedy ()
	{
		return comedy;
	}
	public void setAction (boolean action)
	{
		this.action = action;
	}
	public boolean getAction ()
	{
		return action;
	}
	public void setHistorical (boolean historical)
	{
		this.historical = historical;
	}
	public boolean getHistorical ()
	{
		return historical;
	}
	public void setCharacterFocused (boolean characterFocused)
	{
		this.characterFocused = characterFocused;
	}
	public boolean getCharacterFocused ()
	{
		return characterFocused;
	}
	public void setGroupFocused (boolean groupFocused)
	{
		this.groupFocused = groupFocused;
	}
	public boolean getGroupFocused ()
	{
		return groupFocused;
	}
	public void setDisplay(boolean display)
	{
		this.display = display; 
	}
	public boolean getDisplay()
	{
		return display;
	}
	@Override
	public String toString()
	{
		return "\nMovie: " + name.toUpperCase() + "\nYear Released: " + releaseYear + "\n";
	}
	//constructor
	Movie(String name, int releaseYear, boolean animation, boolean liveAction, 
			boolean comedy, boolean action, boolean historical, boolean characterFocused, boolean groupFocused)
	{
		setName(name);
		setReleaseYear(releaseYear);
		setAnimation(animation);
		setLiveAction(liveAction);
		setComedy(comedy);
		setAction(action);
		setHistorical(historical);
		setCharacterFocused(characterFocused);
		setGroupFocused(groupFocused);
	}
	//constructor for customized list
	Movie(String name, int releaseYear, boolean animation, boolean liveAction, 
			boolean comedy, boolean action, boolean historical, boolean characterFocused, boolean groupFocused, boolean display)
	{
		setName(name);
		setReleaseYear(releaseYear);
		setAnimation(animation);
		setLiveAction(liveAction);
		setComedy(comedy);
		setAction(action);
		setHistorical(historical);
		setCharacterFocused(characterFocused);
		setGroupFocused(groupFocused);
		setDisplay(display);
	}
}
