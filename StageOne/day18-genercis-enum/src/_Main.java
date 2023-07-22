/**
 * <table>
 * <caption>day18: 泛型和枚举<caption/>
 * <tr></tr>
 * <tr><th>source code</th>
 *     <th>Description</th></tr>
 *
 * <tr>--------------</tr>
 *
 * <tr><th>Pakage generic_supper_array</th>
 *     <td>该包下的案例主要是通过泛型改造 day09的supperArray.java，进一步了解泛型</td></tr>
 *
 * <tr>--------------</tr>
 *
 * <tr><td><code>GenericFuncTest.java</code></td>
 *     <td>学习 泛型方法<td/></tr>
 *
 * <tr>--------------</tr>
 *
 * <tr><th>Pakage generic_extend</th>
 *     <td>主要列举了在继承关系下又如何去泛型<td/></tr>

 * <tr><td><code>Comparator.java</code></td>
 *     <td>定义一个用 来比较数据 的 泛型接口<td/></tr>
 *
 * <tr><td><code>StudentComparator.java</code></td>
 *     <td>列举了 StudentComparator类 实现 Compatator泛型接口, 实现类没有明确泛型的类型<td/></tr>
 *
 * <tr><td><code>User.java</code></td>
 *     <td>定义 User类, 用来实例化对象<td/></tr>
 *
 * <tr><td><code>UserAgeComparator.java</code></td>
 *     <td>列举了 UserAgeCompatator 实现类 实现了 Comparator 泛型接口, 并且明确了泛型的类型为 User<td/></tr>
 *
 * <tr><td><code>UserNameComparator.java</code></td>
 *     <td>列举了 UserNameComparator实现类 实现了 Comparator 泛型接口，并且不明确泛型的类型，等后续创建实例时再确定类型<td/></tr>
 *
 * <tr>--------------</tr>
 *
 <tr><th>Pakage homework1</th>
 *     <td>
 *         一个实战案例, 和genericExtend.UserNameComparator.java同理<br/>
 *          进一步改造 超级数组与链表, 定义一个 Supper泛型接口 抽离出它们的一些共有的功能方法, 超级数组与链表都去实现这个泛型接口
 *     <td/></tr>
 *
 * <tr>--------------</tr>
 *
 * <tr><th>Pakage generic_wildcard</th>
 *     <td>类型通配符的使用<td/></tr>
 *
 * <tr><td><code>Test1.java</code></td>
 *     <td>当方法参数是一个带参数类型的泛型的时候，对应的一些情况<td/></tr>
 *
 * <tr><td><code>Test2.java</code></td>
 *     <td>类型通配符: 无界<td/></tr>
 *
 * <tr><td><code>Test3.java</code></td>
 *     <td>类型通配符: 上界<td/></tr>
 *
 * <tr><td><code>Test4.java</code></td>
 *     <td>类型通配符: 下界<td/></tr>
 *
 * <tr>--------------</tr>
 *
 * <tr><th>Pakage generic_wipe</th>
 *     <td>了解类型擦除的机制，以及它所带来的影响<td/></tr>
 *
 * <tr><td><code>Test1.java</code></td>
 *     <td>泛型不能是基本数据类型<td/></tr>
 *
 * <tr><td><code>Test2.java</code></td>
 *     <td>方法参数为 带类型参数的泛型的时候, 可能无法构成重载<td/></tr>
 *
 * <tr><td><code>Test3.java</code></td>
 *     <td>类型擦除和多态的冲突<td/></tr>
 *
 * <tr>--------------</tr>
 *
 * <tr><td><code>GenericStaticTest.java</code></td>
 *     <td>静态方法和静态类中的问题<td/></tr>
 *
 * <tr>--------------</tr>
 *
 * <tr><th>Pakage enum_introduce</th>
 *     <td>引入枚举<td/></tr>
 *
 * <tr><td><code>SeasonSingleton.java</code></td>
 *     <td>定义一个 单例的季节类<td/></tr>
 *
 * <tr><td><code>SeasonEnum.java</code></td>
 *     <td>定义枚举， 了解枚举的机制，枚举的常用方法，枚举类中添加新的方法<td/></tr>
 *
 * <tr>--------------</tr>
 *
 * <tr><th>Pakage enum_switch_staticimport</th>
 *     <td>关于枚举的其他知识点<td/>
 *
 * <tr><td><code>Test.java</code></td>
 *     <td>Enum的静态导入，Switch语句中的Enum<td/>
 *
 * <tr>--------------</tr>
 *
 * <tr><td><code>EnumSingleton.java</code></td>
 *     <td>用枚举实现单例设计模式<td/>
 * <table/>
 */
public class _Main {}