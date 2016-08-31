package com.stormma.day7;

import java.util.Calendar;
import java.util.Scanner;
import java.io.*;

public class MainA2
{
	int a[] = {2272,3799,13458,14985,17258,18785,21058,22587,24859,26387,28659,30187,32460,33987,36260,37787,40060,41587,43861,45387,47663,49188,58849,60374,62647,64175,102636,141098,143371,144898,147171,148698,150971,152500,154772,156300,158572,160100,162373,163900,166173,167700,177360,178887,181161,182687,184963,186488,188762,190287,192560,194087,196359,197886,200159,201686,203959,205486,207759,209288,211560,213088,222748,224276,226549,228076,230349,231876,234149,235676,237950,239476,241752,243277,245551,247076,249349,250876,253148,254675,256948,258475,268134,269661,271934,273463,275735,277263,279535,281063,283336,284863,287136,288663,290936,292463,294737,296263,298539,300064,302338,303863,313523,315050,317322,318849,321122,322649,324922,326449,328722,330251,332523,334051,336323,337851,340124,341651,343924,345451,347724,349251,358913,360439,362715,364240,366514,368039,370312,371839,374111,375638,377911,379438,381711,383238,385511,387040,389312,390840,393112,394640,404300,405827,408100,409627,411900,413427,415701,417227,419503,421028,423302,424827,427100,428627,430899,432426,434699,436226,438499,440026,449686,451215,453487,455015,457287,458815,461088,462615,464888,466415,468688,470215,472489,474015,476291,477816,480090,481615,483888,485415,495073,496600,498873,500400,502673,504200,506473,508002,510274,511802,514074,515602,517875,519402,521675,523202,525475,527002,529276,530802,540465,541990,544264,545789,548062,549589,551861,553388,555661,557188,559461,560988,563261,564790,567062,568590,570862,572390,574663,576190,585850,587377,589650,591177,629639,668100,670376,671901,674175,675700,677973,679500,681772,683299,685572,687099,689372,690899,693172,694701,704360,705888,708160,709688,711961,713488,715761,717288,719561,721088,723362,724888,727164,728689,730963,732488,734761,736289,774750,813212,851673,890135,928596,967058,1005519,1043981,1082442,1120904,1159365,1197827,1236289,1274750,1313212,1351673,1390135,1428596,1467058,1505519,1507795,1509320,1518981,1520506,1522779,1524306,1526578,1528105,1530378,1531905,1534178,1535705,1537978,1539507,1541779,1543307,1545579,1547107,1549380,1550907,1553180,1554707,1564367,1565894,1568168,1569694,1571970,1573495,1575769,1577294,1579567,1581094,1583366,1584893,1587166,1588693,1590966,1592493,1594766,1596295,1598567,1600095,1609755,1611283,1613556,1615083,1617356,1618883,1621156,1622683,1624957,1626483,1628759,1630284,1632558,1634083,1636356,1637883,1640155,1641682,1643955,1645482,1655141,1656668,1658941,1660470,1662742,1664270,1666542,1668070,1670343,1671870,1674143,1675670,1677943,1679470,1681744,1683270,1685546,1687071,1689345,1690870,1700530,1702057,1704329,1705856,1708129,1709656,1711929,1713456,1715729,1717258,1719530,1721058,1723330,1724858,1727131,1728658,1730931,1732458,1734731,1736258,1745920,1747446,1749722,1751247,1753521,1755046,1757319,1758846,1761118,1762645,1764918,1766445,1768718,1770245,1772518,1774047,1776319,1777847,1780119,1781647,1791307,1792834,1795107,1796634,1798907,1800434,1802708,1804234,1806510,1808035,1810309,1811834,1814107,1815634,1817906,1819433,1821706,1823233,1825506,1827033,1836693,1838222,1840494,1842022,1880483,1918945,1921218,1922745,1925018,1926545,1928818,1930345,1932619,1934145,1936421,1937946,1940220,1941745,1944018,1945545,1955203,1956730,1959003,1960530,1962803,1964330,1966603,1968132,1970404,1971932,1974204,1975732,1978005,1979532,1981805,1983332,1985605,1987132,1989406,1990932,2000595,2002120,2004394,2005919,2008192,2009719,2011991,2013518,2015791,2017318,2019591,2021118,2023391,2024920,2027192,2028720,2030992,2032520,2034793,2036320,2045980,2047507,2049780,2051307,2053581,2055107,2057383,2058908,2061182,2062707,2064980,2066507,2068779,2070306,2072579,2074106,2076379,2077906,2080179,2081708,2091367,2092895,2095167,2096695,2098968,2100495,2102768,2104295,2106568,2108095,2110369,2111895,2114171,2115696,2117970,2119495,2121768,2123295,2125567,2127094,2136753,2138280,2140553,2142080,2144353,2145882,2148154,2149682,2151954,2153482,2155755,2157282,2159555,2161082,2163355,2164882,2167156,2168682,2170958,2172483,2182144,2183669,2185942,2187469,2189741,2191268,2193541,2195068,2197341,2198868,2201141,2202670,2204942,2206470,2208742,2210270,2212543,2214070,2216343,2217870,2227530,2229057,2231331,2232857,2235133,2236658,2238932,2240457,2242730,2244257,2246529,2248056,2250329,2251856,2254129,2255656,2257929,2259458,2261730,2263258,2272918,2274446,2276719,2278246,2280519,2282046,2284319,2285846,2288120,2289646,2291922,2293447,2295721,2297246,2299519,2301046,2303318,2304845,2307118,2308645,2318304,2319831,2322104,2323633,2325905,2327433,2329705,2331233,2333506,2335033,2337306,2338833,2341106,2342633,2344907,2346433,2348709,2350234,2352508,2354033,2363693,2365220,2367492,2369019,2407480,2445942,2448215,2449742,2452015,2453544,2455816,2457344,2459616,2461144,2463417,2464944,2467217,2468744,2471017,2472544,2482206,2483732,2486008,2487533,2489807,2491332,2493605,2495132,2497404,2498931,2501204,2502731,2505004,2506531,2508804,2510333,2512605,2514133,2516405,2517933,2527593,2529120,2531393,2532920,2535193,2536720,2538994,2540520,2542796,2544321,2546595,2548120,2550393,2551920,2554192,2555719,2557992,2559519,2561792,2563319,2572979,2574508,2576780,2578308,2580580,2582108,2584381,2585908,2588181,2589708,2591981,2593508,2595782,2597308,2599584,2601109,2603383,2604908,2607181,2608708,2618366,2619893,2622166,2623693,2625966,2627493,2629766,2631295,2633567,2635095,2637367,2638895,2641168,2642695,2644968,2646495,2648768,2650295,2652569,2654095,2663758,2665283,2667557,2669082,2671355,2672882,2675154,2676681,2678954,2680481,2682754,2684281,2686554,2688083,2690355,2691883,2694155,2695683,2697956,2699483,2709143,2710670,2712943,2714470,2716744,2718270,2720546,2722071,2724345,2725870,2728143,2729670,2731942,2733469,2735742,2737269,2739542,2741069,2743342,2744871,2754530,2756058,2758330,2759858,2762131,2763658,2765931,2767458,2769731,2771258,2773532,2775058,2777334,2778859,2781133,2782658,2784931,2786458,2788730,2790257,2799916,2801443,2803716,2805243,2807516,2809045,2811317,2812845,2815117,2816645,2818918,2820445,2822718,2824245,2826518,2828045,2830319,2831845,2834121,2835646,2845307,2846832,2849105,2850632,2852904,2854431,2856704,2858231,2860504,2862031,2864304,2865833,2868105,2869633,2871905,2873433,2875706,2877233,2879506,2881033,2890693,2892220,2894494,2896020,2934482,2972943,2975217,2976742,2979015,2980542,2982814,2984341,2986614,2988141,2990414,2991941,2994214,2995743,2998015,2999543,3009203,3010731,3013004,3014531,3016804,3018331,3020604,3022131,3024405,3025931,3028207,3029732,3032006,3033531,3035804,3037331,3039603,3041130,3043403,3044930,3054589,3056116,3058389,3059918,3062190,3063718,3065990,3067518,3069791,3071318,3073591,3075118,3077391,3078918,3081192,3082718,3084994,3086519,3088793,3090318,3099978,3101505,3103777,3105304,3107577,3109104,3111377,3112904,3115177,3116706,3118978,3120506,3122778,3124306,3126579,3128106,3130379,3131906,3134179,3135706,3145368,3146894,3149170,3150695,3152969,3154494,3156767,3158294,3160566,3162093,3164366,3165893,3168166,3169693,3171966,3173495,3175767,3177295,3179567,3181095,3190755,3192282,3194555,3196082,3198355,3199882,3202156,3203682,3205958,3207483,3209757,3211282,3213555,3215082,3217354,3218881,3221154,3222681,3224954,3226481,3236141,3237670,3239942,3241470,3243742,3245270,3247543,3249070,3251343,3252870,3255143,3256670,3258944,3260470,3262746,3264271,3266545,3268070,3270343,3271870,3281528,3283055,3285328,3286855,3289128,3290655,3292928,3294457,3296729,3298257,3300529,3302057,3304330,3305857,3308130,3309657,3311930,3313457,3315731,3317257,3326920,3328445,3330719,3332244,3334517,3336044,3338316,3339843,3342116,3343643,3345916,3347443,3349716,3351245,3353517,3355045,3357317,3358845,3361118,3362645,3372305,3373832,3376105,3377632,3379906,3381432,3383708,3385233,3387507,3389032,3391305,3392832,3395104,3396631,3398904,3400431,3402704,3404231,3406504,3408033,3417692,3419220,3421492,3423020,3461482,3499943,3502216,3503743,3506016,3507543,3509817,3511343,3513619,3515144,3517418,3518943,3521216,3522743,3525015,3526542,3536201,3537728,3540001,3541528,3543801,3545330,3547602,3549130,3551402,3552930,3555203,3556730,3559003,3560530,3562803,3564330,3566604,3568130,3570406,3571931,3581592,3583117,3585390,3586917,3589189,3590716,3592989,3594516,3596789,3598316,3600589,3602118,3604390,3605918,3608190,3609718,3611991,3613518,3615791,3617318,3626978,3628505,3630779,3632305,3634581,3636106,3638380,3639905,3642178,3643705,3645977,3647504,3649777,3651304,3653577,3655104,3657377,3658906,3661178,3662706,3672366,3673894,3676167,3677694,3679967,3681494,3683767,3685294,3687568,3689094,3691370,3692895,3695169,3696694,3698967,3700494,3702766,3704293,3706566,3708093,3717752,3719279,3721552,3723081,3725353,3726881,3729153,3730681,3732954,3734481,3736754,3738281,3740554,3742081,3744355,3745881,3748157,3749682,3751956,3753481,3763141,3764668,3766940,3768467,3770740,3772267,3774540,3776067,3778340,3779869,3782141,3783669,3785941,3787469,3789742,3791269,3793542,3795069,3797342,3798869,3808531,3810057,3812333,3813858,3816132,3817657,3819930,3821457,3823729,3825256,3827529,3829056,3831329,3832856,3835129,3836658,3838930,3840458,3842730,3844258,3853918,3855445,3857718,3859245,3861518,3863045,3865319,3866845,3869121,3870646,3872920,3874445,3876718,3878245,3880517,3882044,3884317,3885844,3888117,3889644,3899304,3900833,3903105,3904633,3906905,3908433,3910706,3912233,3914506,3916033,3918306,3919833,3922107,3923633,3925909,3927434,3929708,3931233,3933506,3935033,3944691,3946218,3948491,3950018,3988479,4026941,4029214,4030743,4033015,4034543,4036815,4038343,4040616,4042143,4044416,4045943,4048216,4049743,4052017,4053543,4063206,4064731,4067005,4068530,4070803,4072330,4074602,4076129,4078402,4079929,4082202,4083729,4086002,4087531,4089803,4091331,4093603,4095131,4097404,4098931,4108591,4110118,4112391,4113918,4116192,4117718,4119994,4121519,4123793,4125318,4127591,4129118,4131390,4132917,4135190,4136717,4138990,4140517,4142790,4144319,4153978,4155506,4157778,4159306,4161579,4163106,4165379,4166906,4169179,4170706,4172980,4174506,4176782,4178307,4180581,4182106,4184379,4185906,4188178,4189705,4199364,4200891,4203164,4204691,4206964,4208493,4210765,4212293,4214565,4216093,4218366,4219893,4222166,4223693,4225966,4227493,4229767,4231293,4233569,4235094,4244755,4246280,4248553,4250080,4252352,4253879,4256152,4257679,4259952,4261479,4263752,4265281,4267553,4269081,4271353,4272881,4275154,4276681,4278954,4280481,4290141,4291668,4293942,4295468,4297744,4299269,4301543,4303068,4305341,4306868,4309140,4310667,4312940,4314467,4316740,4318267,4320540,4322069,4324341,4325869,4335529,4337057,4339330,4340857,4343130,4344657,4346930,4348457,4350731,4352257,4354533,4356058,4358332,4359857,4362130,4363657,4365929,4367456,4369729,4371256,4380915,4382442,4384715,4386244,4388516,4390044,4392316,4393844,4396117,4397644,4399917,4401444,4403717,4405244,4407518,4409044,4411320,4412845,4415119,4416644,4426304,4427831,4430103,4431630,4433903,4435430,4437703,4439230,4441503,4443032,4445304,4446832,4449104,4450632,4452905,4454432,4456705,4458232,4460505,4462032,4471694,4473220,4475496,4477021,4515483,4553944,4556217,4557744,4560016,4561543,4563816,4565343,4567616,4569143,4571416,4572945,4575217,4576745,4579017,4580545,4590205,4591732,4594005,4595532,4597805,4599332,4601606,4603132,4605408,4606933,4609207,4610732,4613005,4614532,4616804,4618331,4620604,4622131,4624404,4625931,4635591,4637120,4639392,4640920,4643192,4644720,4646993,4648520,4650793,4652320,4654593,4656120,4658394,4659920,4662196,4663721,4665995,4667520,4669793,4671320,4680978,4682505,4684778,4686305,4688578,4690105,4692378,4693907,4696179,4697707,4699979,4701507,4703780,4705307,4707580,4709107,4711380,4712907,4715181,4716707,4726370,4727895,4730169,4731694,4733967,4735494,4737766,4739293,4741566,4743093,4745366,4746893,4749166,4750695,4752967,4754495,4756767,4758295,4760568,4762095,4771755,4773282,4775555,4777082,4779356,4780882,4783158,4784683,4786957,4788482,4790755,4792282,4794554,4796081,4798354,4799881,4802154,4803681,4805954,4807483,4817142,4818670,4820942,4822470,4824743,4826270,4828543,4830070,4832343,4833870,4836144,4837670,4839946,4841471,4843745,4845270,4847543,4849070,4851342,4852869,4862528,4864055,4866328,4867855,4870128,4871657,4873929,4875457,4877729,4879257,4881530,4883057,4885330,4886857,4889130,4890657,4892931,4894457,4896733,4898258,4907919,4909444,4911717,4913244,4915516,4917043,4919316,4920843,4923116,4924643,4926916,4928445,4930717,4932245,4934517,4936045,4938318,4939845,4942118,4943645,4953305,4954832,4957106,4958632,4960908,4962433,4964707,4966232,4968505,4970032,4972304,4973831,4976104,4977631,4979904,4981431,4983704,4985233,4987505,4989033,4998693,5000221,5002494,5004021,5042483,5080944,5083217,5084744,5087018,5088544,5090820,5092345,5094619,5096144,5098417,5099944,5102216,5103743,5106016,5107543,5117202,5118729,5121002,5122531,5124803,5126331,5128603,5130131,5132404,5133931,5136204,5137731,5140004,5141531,5143805,5145331,5147607,5149132,5151406,5152931,5162591,5164118,5166390,5167917,5170190,5171717,5173990,5175517,5177790,5179319,5181591,5183119,5185391,5186919,5189192,5190719,5192992,5194519,5196792,5198319,5207981,5209507,5211783,5213308,5215582,5217107,5219380,5220907,5223179,5224706,5226979,5228506,5230779,5232306,5234579,5236108,5238380,5239908,5242180,5243708,5253368,5254895,5257168,5258695,5260968,5262495,5264769,5266295,5268571,5270096,5272370,5273895,5276168,5277695,5279967,5281494,5283767,5285294,5287567,5289094,5298754,5300283,5302555,5304083,5306355,5307883,5310156,5311683,5313956,5315483,5317756,5319283,5321557,5323083,5325359,5326884,5329158,5330683,5332956,5334483,5344141,5345668,5347941,5349468,5351741,5353268,5355541,5357070,5359342,5360870,5363142,5364670,5366943,5368470,5370743,5372270,5374543,5376070,5378344,5379870,5389533,5391058,5393332,5394857,5397130,5398657,5400929,5402456,5404729,5406256,5408529,5410056,5412329,5413858,5416130,5417658,5419930,5421458,5423731,5425258,5434918,5436445,5438718,5440245,5442519,5444045,5446321,5447846,5450120,5451645,5453918,5455445,5457717,5459244,5461517,5463044,5465317,5466844,5469117,5470646,5480305,5481833,5484105,5485633,5487906,5489433,5491706,5493233,5495506,5497033,5499307,5500833,5503109,5504634,5506908,5508433,5510706,5512233,5514505,5516032,5525691,5527218,5529491,5531018,5569479,5607941,5610213,5611741,5614013,5615541,5617814,5619341,5621614,5623141,5625414,5626941,5629215,5630741,5633017,5634542,5644203,5645728,5648001,5649528,5651800,5653327,5655600,5657127,5659400,5660927,5663200,5664729,5667001,5668529,5670801,5672329,5674602,5676129,5678402,5679929,5689589,5691116,5693390,5694916,5697192,5698717,5700991,5702516,5704789,5706316,5708588,5710115,5712388,5713915,5716188,5717715,5719988,5721517,5723789,5725317,5734977,5736505,5738778,5740305,5742578,5744105,5746378,5747905,5750179,5751705,5753981,5755506,5757780,5759305,5761578,5763105,5765377,5766904,5769177,5770704,5780363,5781890,5784163,5785692,5787964,5789492,5791764,5793292,5795565,5797092,5799365,5800892,5803165,5804692,5806966,5808492,5810768,5812293,5814567,5816092,5825752,5827279,5829551,5831078,5833351,5834878,5837151,5838678,5840951,5842480,5844752,5846280,5848552,5850080,5852353,5853880,5856153,5857680,5859953,5861480,5871142,5872668,5874944,5876469,5878743,5880268,5882541,5884068,5886340,5887867,5890140,5891667,5893940,5895467,5897740,5899269,5901541,5903069,5905341,5906869,5916529,5918056,5920329,5921856,5924129,5925656,5927930,5929456,5931732,5933257,5935531,5937056,5939329,5940856,5943128,5944655,5946928,5948455,5950728,5952255,5961915,5963444,5965716,5967244,5969516,5971044,5973317,5974844,5977117,5978644,5980917,5982444,5984718,5986244,5988520,5990045,5992319,5993844};
	public static void main(String[] args) throws IOException
	{
		BufferedWriter bufw = null;
		bufw = new BufferedWriter(
					new OutputStreamWriter (new FileOutputStream("out.txt")));
		int sum = 0;
		for (int i = 1; i <= 1000000000; i++)
		{
			if (i % 500000 == 0)
			{
				bufw.write(sum+",");
				sum = 0;
			}
			if (cal(i))
				sum += i;
		}
		if (cal(13))
			System.out.println(13);
	}
	public static boolean cal (int i)
	{
		if (i % 13 == 0)
		{
			while (i >= 0)
			{
				if (i % 100 == 13)
				{
					return true;
				}
				i /= 10;
			}
		}
		return false;
	}
}
