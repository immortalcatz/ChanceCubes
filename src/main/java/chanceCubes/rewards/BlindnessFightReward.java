package chanceCubes.rewards;

import chanceCubes.CCubesCore;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class BlindnessFightReward implements IChanceCubeReward
{

	@Override
	public void trigger(World world, int x, int y, int z, EntityPlayer player)
	{
		player.addPotionEffect(new PotionEffect(Potion.blindness.id, 100, 2));
		player.addChatMessage(new ChatComponentText("Fight!!!"));
		
		player.setRotationYawHead(player.getRotationYawHead() + world.rand.nextInt(180));

		world.setBlockToAir(x, y + 1, z);
		EntitySkeleton skele = new EntitySkeleton(world);
		skele.setPosition(x, y, z);
		world.spawnEntityInWorld(skele);
	}

	@Override
	public int getChanceValue()
	{
		return 0;
	}

	@Override
	public String getName()
	{
		return CCubesCore.MODID + ":Blindness_Fight";
	}

}
