import java.io.InputStream;

/**
 * 
 * @author dung
 *
 */
public class e
{
  // many flags
  public int a = 1;
  public int b = 0;
  public boolean c = false;
  public boolean d = false;
  public boolean e = false;
  public boolean f = false;
  public int g = 1;
  public int h = 1;
  public int i;
  public int j;
  public int k;
  public byte[] l = new byte[1000];
  public int[] m = new int[9];
  public int n = -1;
  public int o = -1;

  /**
   * 
   * @param paramInt
   * @return
   */
  public boolean a(int paramInt)
  {
    // This function change value of many flag.
    // Flags use may be for screen switch game mode switch, bot or player status ...
    int i1 = 0;
    if (this.n != paramInt)
    {
      if (this.c) // init false
        this.a = this.g; // a=1, g=1 init.
      else if (this.d) // init false
        this.a = this.h;
      else
        this.a = 1;
      if (this.e)
        this.a = 5;
      this.b = 0;
      this.n = paramInt;
    }
    this.o = 0;
    for (int i2 = 0; i2 < 9; i2++)
      this.m[i2] = 0;
    this.k = c(paramInt);
    if (this.k == -1)
    {
      this.k = 0;
      return false;
    }
    while (a('+'))
      this.o = (this.m[(i1++)] = b(this.k));
    this.k += 2;
    return true;
  }

  /**
   * 
   * @param paramInt
   * @return
   */
  public int b(int paramInt)
  {
    // This func seem to be contrel aircraft moving
    int i2 = 0;
    for (int i1 = paramInt; i1 < this.j; i1++)
      if ((this.l[i1] >= 48) && (this.l[i1] <= 57))
        break;
    while (i1 < this.j)
    {
      if ((this.l[i1] >= 48) && (this.l[i1] > 57))
        break;
      i2 *= 10;
      i2 += this.l[i1] - 48;
      i1++;
    }
    this.k = i1;
    return i2;
  }

  /**
   * 
   * @param paramString
   */
  public void a(String paramString)
  {
    String str = "/text/" + paramString + ".txt";
    try
    {
      InputStream localInputStream = getClass().getResourceAsStream(str);
      this.j = localInputStream.read(this.l);
      this.l[this.j] = 0;
      localInputStream.close();
    }
    catch (Exception localException)
    {
    }
    b();
    this.k = 0;
  }

  /**
   * 
   * @return
   */
  public String a()
  {
    String str = null;
    for (int i1 = this.k; i1 < this.j; i1++)
    {
      if (this.l[i1] == 60)
      {
        this.k = i1;
        return null;
      }
      if (this.l[i1] != 10)
        continue;
      str = new String(this.l, this.k, i1 - this.k);
      break;
    }
    this.k = (i1 + 1);
    return str;
  }

  /**
   * 
   * @param paramInt
   * @return
   */
  public int c(int paramInt)
  {
    for (int i1 = 0; i1 < this.j; i1++)
      if ((this.l[i1] == 60) && (b(i1) == paramInt))
        return i1;
    return -1;
  }

  /**
   * 
   */
  public void b()
  {
    this.i = 0;
    for (int i1 = 0; i1 < this.j; i1++)
    {
      if (this.l[i1] != 10)
        continue;
      this.i += 1;
    }
    this.n = -1;
  }

  /**
   * 
   * @param paramChar
   * @return
   */
  public boolean a(char paramChar)
  {
    for (int i1 = this.k; i1 < this.j; i1++)
    {
      if (this.l[i1] == 10)
      {
        this.k = (i1 - 1);
        return false;
      }
      if (this.l[i1] == paramChar)
        break;
    }
    this.k = i1;
    return true;
  }
}