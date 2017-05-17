package chanceCubes.util;

import net.minecraft.util.DamageSource;

public class CCubesDamageSource extends DamageSource
{
	public static final CCubesDamageSource MATH_FAIL = new CCubesDamageSource("mathdeath");
	public static final CCubesDamageSource MAZE_FAIL = new CCubesDamageSource("mazedeath");
	public static final CCubesDamageSource QUESTION_FAIL = new CCubesDamageSource("questiondeath");

	public CCubesDamageSource(String id)
	{
		super(id);
		super.setDamageBypassesArmor();
		super.setDamageIsAbsolute();
	}

}